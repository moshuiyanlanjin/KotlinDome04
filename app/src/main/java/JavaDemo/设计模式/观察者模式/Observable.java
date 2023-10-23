package JavaDemo.设计模式.观察者模式;

//TODO 抽象层，被观察者
public interface Observable {

    //添加
    void addObservver(Observer observer);
    //移除
    void removeObserver(Observer observer);
    //通知改变
    void notifyObservers();
    //发布一条消息
    void pushMessage(String message);
}
