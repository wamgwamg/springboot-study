package com.example.skill.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : wangye
 * @date: 2021年11月25日 6:52 PM
 * @description: 线程 -- 操作 --资源
 */
public class BuyTicketTest {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) ticket.buy();
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) ticket.buy();
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) ticket.buy();
        }, "C").start();

    }

}

class Ticket {
    private int num = 100;
    Lock lock = new ReentrantLock();

    public void buy() {
        lock.lock();
        try {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + num-- + "，还剩" + num);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}