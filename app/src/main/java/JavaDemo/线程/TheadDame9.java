package JavaDemo.线程;

import android.os.SystemClock;

public class TheadDame9 extends Thread {

    @Override
    public void run() {
        super.run();
        int i = 0;
        System.out.println("isInterrupted" + isInterrupted() + "");
        while (!isInterrupted()){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                interrupt();
            }
            i++;
                System.out.println("运行中" + i);

        }
    }

    public static void main(String[] args) {
        TheadDame9 theadDame9 = new TheadDame9();
        theadDame9.start();
        try {
            Thread.sleep(1000);
            theadDame9.interrupt();
            System.out.println("执行了" + interrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
