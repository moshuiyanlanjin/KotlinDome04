package JavaDemo.线程;

public class ThredDemo2 implements Runnable{

    @Override
    public void run() {
        System.out.println("我是子线程：" + Thread.currentThread().getName());
        a();
    }

    private synchronized void a() {
        System.out.println(Thread.currentThread().getName() + ":我是子线程a开始");
        b();
        System.out.println(Thread.currentThread().getName() + ":我是子线程a结束");
    }

    private synchronized void b() {
        System.out.println(Thread.currentThread().getName() + ":我是子线程b");
    }

    public static void main(String[] args) {
        new Thread(new ThredDemo2()).start();
    }
}
