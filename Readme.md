# JVM

HotSpot VM，OracleJDK（商⽤）和 OpenJDK（开源）的默认虚拟机，也是⽬前使⽤最⼴泛的 Java 虚拟机，

# JVM 的组织架构

JVM ⼤致可以划分为三个部⻔，分别是类加载器（Class Loader）、运⾏时数据区（Runtime Data Areas）和执⾏ 引擎（Excution Engine）

![image-20241215223807462](https://raw.githubusercontent.com/a186232641/images/master/img/202412152238205.png)

### 运⾏时数据区

运⾏时数据区通常包括：⽅法区、堆、虚拟机栈、本地⽅法栈以及程序计数器五个部分,版本不同运行时数据区不同。其中 PC 寄存器、虚拟机栈以及本地⽅法栈属于线程私有的，堆以及元空间（⽅法区的实现）属于共享数据区

![image-20241215224242493](https://raw.githubusercontent.com/a186232641/images/master/img/202412152242964.png)

### 执⾏引擎

![image-20241215224405966](https://raw.githubusercontent.com/a186232641/images/master/img/202412152244080.png)

解释器：读取字节码，然后执⾏指令。因为它是⼀⾏⼀⾏地解释和执⾏指令，所以它可以很快地解释字节码， 但是执⾏起来会⽐较慢（毕竟要⼀⾏执⾏完再执⾏下⼀⾏）。 即时编译器：执⾏引擎⾸先按照解释执⾏的⽅式来执⾏，随着时间推移，即时编译器会选择性的把⼀些热点代 码编译成本地代码。执⾏本地代码⽐⼀条⼀条进⾏解释执⾏的速度快很多，因为本地代码是保存在缓存⾥的。 垃圾回收器，⽤来回收堆内存中的垃圾对象。

![image-20241215224623958](https://raw.githubusercontent.com/a186232641/images/master/img/202412152246680.png)

### 编译器

![image-20241215225230228](https://raw.githubusercontent.com/a186232641/images/master/img/202412152252517.png)

JVM 就是靠解析这些字节码指令来完成程序执⾏的。常⻅的执⾏⽅式有两种，⼀种是**解释执⾏**，对字节码逐条解释 执⾏；⼀种是 JIT，也就是**即时编译**，它会在运⾏时将**热点代码优化并缓存起来**，下次再执⾏的时候直接使⽤缓存 起来的机器码，⽽不需要再次解释执⾏。

![image-20241215225405521](https://raw.githubusercontent.com/a186232641/images/master/img/202412152254483.png)

![image-20241215225724092](https://raw.githubusercontent.com/a186232641/images/master/img/202412152257367.png)

PC 寄存器存储的是下⼀个字节码指令的地址。如果虚拟机中的当前线程执⾏的是 native ⽅法，那么 PC 寄存器中的值为 undefined。如果遇到判断分⽀、循环以及异常等不同的控制转移语句，PC 寄存器会被置为⽬标字节码指令的地址。

![image-20241215230129821](./Readme.assets/image-20241215230129821.png)