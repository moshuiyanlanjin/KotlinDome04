package JavaDemo.线程;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TheadDame8 {


    public static void main(String[] args) {
        /**
         * 线程池参数
         * 参数一：核心线程数，永远处于打开状态，只有在线程池关闭的时候才会被回收(如果用ThreadPoolExecutor接受
         * 的情况下设置allowCoreThreadTimeOut(true)则核心线程也可以关闭)
         * 参数二：线程总数
         * 参数三：等待时间，主要为非核心线程设置
         * 参数四：等待时间的单位
         * 参数五：设置等待队列
         * 参数六：传入线程的工厂
         * 参数七：拒绝策略
         */
        ExecutorService executorService = new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        //获取cpu可用的最大核心数
        // cpu密集型：cpu可用的最大核心数最多加1，这个值来设置最大线程数（加1的原因，因为操作系统是有限的，基本都会把磁盘的
        // 一部分空间作为虚拟内存来用，但是虚拟内存要比内存慢，当要用到时需要把虚拟内存资源放入内存中，可能产生页缺失的状态。+1
        // 为了充分利用每一个cpu空间）
        //IO密集型（磁盘、网络） 线程数，cpu最大核心数*2
        //混合型：如果上面两种性能消耗相差不大，则按io密集型计算
        int i1 = Runtime.getRuntime().availableProcessors();



        for (int i = 0; i < 7; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "线程");
                }
            });
        }
        
        executorService.shutdown();//尝试关闭线程，对没有执行任务的线程进行中断
        executorService.shutdownNow();//强制关闭，尝试关闭正在执行任务的线程

    }


}
