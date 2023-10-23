package JavaDemo.数据结构.枚举;

public class EnumDemo {

    public static void main(String[] args) {
        System.out.println(DayDemo.valueOf("ONE"));
        DayDemo[] values = DayDemo.values();
        for (DayDemo v : values){
            System.out.println(v);
        }

        DaySDemo.DaySDemo.num(1,3);
        System.out.println(DaySDemo.DaySDemo.num(2,2.0));
    }
}
