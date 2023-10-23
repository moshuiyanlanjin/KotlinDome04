package JavaDemo.反射和注解;



import com.example.kotlindemo04.MainActivity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class FansheMain {

    public static void main(String[] args) {

        //创建对象及获取属性
    //   demo1();
        //获取方法
        demo2();
        //获取构造器
     //   demo3();
    }

    private static void demo3() {


        Class<Studen> studenClass = Studen.class;

        //获取当前运行类中public的构造器
        Constructor[] constructors = studenClass.getConstructors();

        for (Constructor c : constructors){
            System.out.println(c.getName());
        }
        //获取当前运行类中所有的构造器
        Constructor<?>[] declaredConstructors = studenClass.getDeclaredConstructors();
        for (Constructor c : constructors){
            System.out.println(c.getName());
        }
    }

    private static void demo2() {
        Class<?> studenClass = MainActivity.class;

        //获取当前类及父类中所有的publin的方法
        Method[] methods = studenClass.getMethods();
        for (Method m : methods){
            System.out.println(m);
            System.out.println(m.getName());
        }
        //获取当前类的全部方法（包括私有），但是不能获取父类的任何方法
        Method[] declaredMethods = studenClass.getDeclaredMethods();
        for (Method m:declaredMethods){
            System.out.println(m);
            //获取权限修饰符
            int modifiers = m.getModifiers();
            System.out.println("权限修饰符：" + Modifier.toString(modifiers));

            //拿到注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation annotation : annotations){
                System.out.println("注解是：" + annotation);
            }

            //获取返回值类型
            System.out.println(m.getReturnType().getName());


            //获取变量名
            String name = m.getName();
            System.out.println("当前方法的名称是：" + name);
        }
    }

    private static void demo1() {

        try {
            //根据反射创建一个studen的对象
            Class aClass = Class.forName("JavaDemo.反射和注解.Studen");
            Studen studer = (Studen) aClass.newInstance();
            System.out.println(studer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Class<Studen> studer = Studen.class;
        //获取当前类和父类的public的属性
        Field[] fields = studer.getFields();
        for (Field f : fields){
            System.out.println("public:" + f);
        }

        //获取当前类的全部属性（包括私有），但是不能获取父类的任何属性
        Field[] declaredFields = studer.getDeclaredFields();
        for (Field f:declaredFields){
            System.out.println("全部：" + f);
            //获取权限修饰符
            int modifiers = f.getModifiers();
            System.out.println("权限修饰符：" + Modifier.toString(modifiers));
            //获取数据的类型
            Class type = f.getType();
            System.out.println("数据类型是：" + type.getSimpleName());

            //获取变量名
            String name = f.getName();
            System.out.println("当前变量的名称是：" + name);
        }
    }
}
