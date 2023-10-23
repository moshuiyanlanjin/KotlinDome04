package JavaDemo.设计模式.代理模式.agent;


import JavaDemo.设计模式.代理模式.statics.Massage;

/**
 * 代理对象：马杀鸡经纪人
 */
public class Agent implements Massage {

    private final Massage massage;

    public Agent(Massage massage) {
        this.massage = massage;
    }

    //....前置处理
    public void before() {
        System.out.println("一条龙服务,包君满意");
    }

    //....后置处理
    public void after() {
        System.out.println("满意度调查");
    }

    @Override
    public void massage() {
        before();
        massage.massage();
        after();
    }
}
