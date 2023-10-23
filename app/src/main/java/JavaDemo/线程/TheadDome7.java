package JavaDemo.线程;

public class TheadDome7 implements Runnable {

    private Thread t;
    public TheadDome7(Thread t){
        this.t = t;
    }
    @Override
    public void run() {
        try {
            if(t !=null){
                t.join();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new TheadDome7(null), "t1");
        Thread t2 = new Thread(new TheadDome7(t1), "t2");
        Thread t3 = new Thread(new TheadDome7(t2), "t3");
        t1.start();
        t2.start();
        t3.start();
        try {
            t2.join();
        }catch (Exception e){

        }


        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
