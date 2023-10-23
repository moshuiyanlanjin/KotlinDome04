package JavaDemo.数据结构.栈和队列;


import java.util.Random;

import JavaDemo.数据结构.链表和递归.LinkedListQueue;

public class QueueMain {

    public static void main(String[] args) {

       /* ArrayQueue<Integer> queue = new ArrayQueue<>();

        for (int i = 0; i < 21; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        for (int i = 0; i < queue.getSize(); i++) {
            if(i % 3 == 2){
                queue.dequeue();
            }
        }
        System.out.println(queue);*/

        LoopQueue<Integer> queue = new LoopQueue<>();

        for (int i = 0; i < 21; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                System.out.println(queue.dequeue());
            }
            System.out.println(queue);
        }

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 100; i++) {
            linkedListQueue.enqueue(i);
        }
        System.out.println(linkedListQueue.toString());
        int c = 100000;
        ArrayQueue<Integer> q = new ArrayQueue<>();
        System.out.println("普通数组队列时间：" + getTime(q,c));
        LoopQueue<Integer> q1 = new LoopQueue<>();
        System.out.println("循环数组队列时间："  + getTime(q1,c));
        LinkedListQueue<Integer> q2 = new LinkedListQueue<>();
        System.out.println("链表队列时间：" + getTime(q2,c));

    }





    private static double getTime(Queue<Integer> q, int c){
        double starttime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < c; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < c; i++) {
            q.dequeue();
        }
        double endtime = System.nanoTime();
        return (endtime - starttime) / 1000000000.0;
    }
}
