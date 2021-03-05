package com.example.skill.threadLocal;

/**
 * @author : wangye
 * @date: 2020-10-30
 * @description:
 */
public class RunnableTest implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "线程-->" + i);
        }
    }


    public static void main(String[] args) {
        RunnableTest mt1 = new RunnableTest();    // 实例化对象
        RunnableTest mt2 = new RunnableTest();    // 实例化对象
        Thread t1 = new Thread(mt1,"线程1");       // 实例化Thread类对象
        Thread t2 = new Thread(mt2,"线程2");       // 实例化Thread类对象
        t1.start();    // 启动多线程
        t2.start();    // 启动多线程
    }
}
