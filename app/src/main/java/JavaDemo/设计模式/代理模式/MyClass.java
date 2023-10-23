package JavaDemo.设计模式.代理模式;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


import JavaDemo.设计模式.代理模式.agent.Alvin;
import JavaDemo.设计模式.代理模式.statics.Massage;

public class MyClass {

    public static void main(String[] args) throws Exception {
        //静态代理
//        Massage message = new Lucy();
//        Agent agent = new Agent(message);
//
//        agent.massage();

        //动态代理
        final Alvin alvin = new Alvin();


        Object o = Proxy.newProxyInstance(MyClass.class.getClassLoader(),
                new Class[]{Massage.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        //如果这里调用o，则会隐性的调用0.toSring方法，会将tosring包装成
                        // method方法调用invoke，无限循环调用，造成栈溢出
//                        System.out.println("........." + o);
                        return method.invoke(alvin,objects);
                    }
                });

        Massage massage = (Massage) o;
        massage.massage();

//        Wash wash = (Wash) o;
//        wash.wash();


      //  proxy();
    }


//    private static void proxy() throws Exception {
//        String name = Massage.class.getName() + "$Proxy0";
//        //生成代理指定接口的Class数据
//        byte[] bytes = ProxyGenerator.generateProxyClass(name, new Class[]{Massage.class});
//        FileOutputStream fos = new FileOutputStream("lib/" + name + ".class");
//        fos.write(bytes);
//        fos.close();
//    }
}
