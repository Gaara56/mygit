package com.springboot.springbootdemo;

public class MyThread implements Runnable {
    @Override
    public void run() {
        Singleton singleton = Singleton.getInstance();
        System.out.println(Thread.currentThread().getName() + " " + singleton);
    }
}
