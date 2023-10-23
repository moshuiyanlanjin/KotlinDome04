package JavaDemo.数据结构.数组;

public class ArrayMain {

    public static void main(String[] args) {
        Array<Integer> array = new Array();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1,1000);
        System.out.println(array);

        System.out.println(array.get(10));

        array.remove(2);
        System.out.println(array);


    }


}
