package JavaDemo.设计模式.观察者模式;

//TODO 消息发送者
public class ObservableMain {

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        //被观察者实体类
        WechatServerObservable wechatServerObservable = new WechatServerObservable();
        //将观察者放入被观察者的容器中
        wechatServerObservable.addObservver(new UserPerson("张三"));
        wechatServerObservable.addObservver(new UserPerson("李斯"));
        //被观察者发送消息
        wechatServerObservable.pushMessage("冲锋");
    }
}
