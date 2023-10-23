package JavaDemo.数据结构.链表和递归;



import java.util.Random;

import JavaDemo.数据结构.栈和队列.ArrayStack;
import JavaDemo.数据结构.栈和队列.Stack;

public class LinkedMain {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            list.addFirst(i);
        }
        list.add(2,100);
        System.out.println(list.get(1));
        list.remove(2);
        list.removeLast();
        System.out.println("当前的链表中是否包含5" + list.contains(5) + ",当前的链表数据是：" + list.toString() + "，末尾数据是：" + list.getLast());
     /*  LinkedListStack<Integer> listStack = new LinkedListStack<>();
        for (int i = 0; i < 50; i++) {
            listStack.push(i);
        }
        System.out.println("当前取出的数据是：" + listStack.pop());
        System.out.println("当前的数据是：" + listStack.toString());

        LinkedListStack<Integer> listStack1 = new LinkedListStack<>();
        System.out.println("链表所用时间是：" + getTime(listStack1,10000000));

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        System.out.println("数组所用时间是：" + getTime(arrayStack,10000000));*/
    }



    private static double getTime(Stack<Integer> q, int c){
        double starttime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < c; i++) {
            q.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < c; i++) {
            q.pop();
        }
        double endtime = System.nanoTime();
        return (endtime - starttime) / 1000000000.0;
    }
}
