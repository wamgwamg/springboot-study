package threadLocal;

/**
 * @author : wangye
 * @date: 2020-10-27
 * @description:
 */
public class MyDemoThreadLocal {
    private String content;
    private static ThreadLocal<String> tl = new ThreadLocal<>();

    private String getContent() {
        return tl.get();
    }

    private void setContent(String content) {
        tl.set(content);
    }

    public static void main(String[] args) {
        MyDemoThreadLocal demo = new MyDemoThreadLocal();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.setContent(Thread.currentThread().getName() + "的数据");
                    System.out.println("-----------------------");
                    System.out.println(Thread.currentThread().getName() + "--->" + demo.getContent());
                }
            });
            thread.setName("线程" + i);
            thread.start();
        }
    }
}
