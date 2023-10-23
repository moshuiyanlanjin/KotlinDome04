package JavaDemo.线程;

public class ThredDemo1 implements Runnable{

    private int connet = 100;
    @Override
    public void run() {
        while (connet > 0) {
            thred();
        }
    }

    public void thred(){
        synchronized(this) {
            if (connet > 0) {
                System.out.println(Thread.currentThread().getName() + "正在出票：" + connet);
                connet--;
            }
        }
    }

    public static void main(String[] args) {
        ThredDemo1 thredDemo1 = new ThredDemo1();
        new Thread(thredDemo1,"窗口1").start();
        new Thread(thredDemo1,"窗口2").start();
    }
}