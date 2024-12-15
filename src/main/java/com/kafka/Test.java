package com.kafka;

public class Test {
    public static void main(String[] args) {
        User user = new User();
    Integer result = calculate(user.getAge());
        System.out.println(result);

    }
    private static Integer calculate(Integer a) {
        Integer data = a + 3;
        return data;
    }
}
