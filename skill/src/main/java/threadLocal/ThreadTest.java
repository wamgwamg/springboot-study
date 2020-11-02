package threadLocal;

/**
 * @author : wangye
 * @date: 2020-10-30
 * @description:
 */
public class ThreadTest extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "线程-->" + i);
        }
    }


    public static void main(String[] args) {

        ThreadTest t1 = new ThreadTest();       // 实例化Thread类对象
        ThreadTest t2 = new ThreadTest();
        t1.setName("线程1");// 实例化Thread类对象
        t2.setName("线程2");// 实例化Thread类对象
        t1.start();    // 启动多线程
        t2.start();    // 启动多线程
    }
}
