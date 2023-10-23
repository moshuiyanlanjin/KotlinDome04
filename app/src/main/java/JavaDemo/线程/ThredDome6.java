package JavaDemo.线程;

public class ThredDome6 {

    private int num = 200;

    private class Res{
        public String name;
        public String exe;
        public boolean flag = false;
    }

    class intputTest extends Thread{

        private Res res;
        public intputTest(Res res){
            this.res = res;
        }
        @Override
        public void run() {
            int count = 0;
            while (num > 0) {
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (res){
                    if (res.flag){
                        try {
                            res.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (count == 0) {
                        res.name = "岳飞";
                        res.exe = "男";
                    } else {
                        res.name = "银屏";
                        res.exe = "女";
                    }
                    count = (count + 1) % 2;
                    res.flag = true;
                    res.notify();
                }
                num--;
            }
        }
    }

    class outputTest extends Thread{

        private Res res;
        public outputTest(Res res){
            this.res = res;
        }
        @Override
        public void run() {
            while (num > 0) {
                try {
                    Thread.sleep(10);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (res){
                    if(!res.flag){
                        try {
                            res.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("当前读取的信息是：" + res.name + ":" + res.exe);
                    num--;
                    res.flag = false;
                    res.notify();
                }
            }
        }

    }

    public static void main(String[] args) {
        ThredDome6 thredDome6 = new ThredDome6();
        thredDome6.start();
    }

    private void start(){
        Res res = new Res();

        new intputTest(res).start();
        new outputTest(res).start();
    }
}