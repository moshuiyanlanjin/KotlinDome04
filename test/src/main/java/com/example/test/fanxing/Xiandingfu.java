package com.example.test.fanxing;


import java.util.ArrayList;
import java.util.List;

class A {
}

class B extends A {
}

class C extends B {
}

class D extends C {
}

class DD extends C {
}

class E extends B {
}

class F extends E {
}

class Price<T> {
    private T item;

    public Price(T t) {
        item = t;
    }

    public void set(T t) {
        item = t;
    }

    public T get() {
        return item;
    }

}

public class Xiandingfu<T> {

    public static void main(String[] args) {

        //因为Class<B>和class<C>并没有继承关键，所以无法这样写
         Price<B> pr = new Price<B>(new C());

        //数组之间是可以继承的
        B[] b= new B[]{};
        C[] c = new C[]{};
        A[] a = new A[]{};
        b = c;

        //集合之间是没有这种继承关系的
        List<A> a = new ArrayList<>();
        List<B> b = new ArrayList<>();
        a = b;

        //为了解决容器之间没有继承关系，java引入了上界限定符<? extends T>和下界限定符<? super T>
        Price<? extends B> b = new Price<C>(new C());

        //无法存入任何元素
        b.set(new C());//错误
        b.set(new D());//错误

        //取出的数据只能存入基类中或者object中
        B b1 = b.get();
        Object o1 = b.get();
        C c1 = b.get();//错误


        Price<? super C> p = new Price<B>(new B());
        //下界限定符可以存放数据
        p.set(new D());
        p.set(new C());

        //但是取数据必须放入Object中
        Object object = p.get();
        C c1 = p.get();

        //总结：下界限定符适合存放数据，上界限定符适合存取数据

    }


}
