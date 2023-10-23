package JavaDemo.设计模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

//TODO 被观察者实现层
public class WechatServerObservable implements Observable {

    //容器
    private List<Observer> observers = new ArrayList<>();
    private String message;

    @Override
    public void addObservver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    @Override
    public void pushMessage(String message) {
        this.message = message;
        //通知容器内所有观察者更新了消息
        notifyObservers();
    }
}
