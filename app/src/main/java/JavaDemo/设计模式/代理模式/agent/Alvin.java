package JavaDemo.设计模式.代理模式.agent;


import JavaDemo.设计模式.代理模式.statics.Massage;
import JavaDemo.设计模式.代理模式.statics.Wash;

/**
 *  实实现类： 提供马杀鸡服务的Alvin
 */
public class Alvin implements Massage, Wash {

    @Override
    public void massage() {

        System.out.println("Alvin精通各种按摩手法");
    }

    @Override
    public void wash() {

    }
}
