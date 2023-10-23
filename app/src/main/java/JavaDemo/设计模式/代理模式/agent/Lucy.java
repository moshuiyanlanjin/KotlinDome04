package JavaDemo.设计模式.代理模式.agent;


import JavaDemo.设计模式.代理模式.statics.Massage;

/**
 * 真实实现类： 提供马杀鸡服务的露西
 */
public class Lucy implements Massage {



    @Override
    public void massage() {
        System.out.println("Lucy36D，手法一流");
    }
}
