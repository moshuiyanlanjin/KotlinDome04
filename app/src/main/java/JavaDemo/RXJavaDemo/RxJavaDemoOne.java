package JavaDemo.RXJavaDemo;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;

public class RxJavaDemoOne {

    public static void main(String[] args) {

        rx();
        rxOne();
    }

    private static void rx() {
        RxJavaPlugins.setOnObservableAssembly(
                new Function<Observable, Observable>() {
                    @Override
                    public Observable apply(Observable observable) throws Exception {
                        System.out.println("全局监听有多少地方使用Rxjava" + observable);
                        return observable;
                    }
                }
        );
    }

    private static void rxOne() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                System.out.println("subscribe: onNext=1");
                e.onNext("1");
                System.out.println("subscribe: onNext=2");
                e.onNext("2");

                System.out.println("subscribe: onComplete");
                e.onComplete();
                System.out.println("subscribe: onComplete");
                e.onComplete();

//                System.out.println("subscribe: onError");
//                e.onError(new Throwable("Error"));

                System.out.println("subscribe: onNext=3");
                e.onNext("3");
            }
        })
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Exception {
                        return s+"String";
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        System.out.println("onSubscribe: 订阅");
                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        System.out.println("onNext: " + s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete()");
                    }
                });

    }


}
