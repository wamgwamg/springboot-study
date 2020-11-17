package com.example.skill.threadPool;

/**
 * @author : wangye
 * @date: 2020-11-11
 * @description:
 * 创建一个单线程化的Executor，即只创建唯一的工作者线程来执行任务，它只会用唯一的工作线程来执行任务，
 * 保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。如果这个线程异常结束，会有另一个取代它，保证顺序执行。
 * 单工作线程最大的特点是可保证顺序地执行各个任务，
 * 并且在任意给定的时间不会有多个线程是活动的。
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class NewSingleThreadExecutorTest {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}


