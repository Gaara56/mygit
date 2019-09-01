package com.springboot.springbootdemo;

public class Test {

    public static void main(String[] args) {
        /*Thread th1 = new Thread(new MyThread());
        Thread th2 = new Thread(new MyThread());
        th1.start();
        th2.start();*/
        User u = new User();
        u.setI(2);
        System.out.println(u.getI());

        System.out.println("end");

    }
}
