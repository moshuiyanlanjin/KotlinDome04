package JavaDemo.数据结构.链表和递归;

import androidx.annotation.NonNull;

import JavaDemo.数据结构.栈和队列.Queue;


public class LinkedListQueue<E> implements Queue<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this.e = e;
            this.next = null;
        }
    }

    //当前队列的队首和队尾
    private Node head,tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if(tail == null){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("当前队列为空...");
        }
        Node retNode = head;
        head = retNode.next;
        retNode.next = null;
        if(head == null){
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("当前队列为空...");
        }
        return head.e;
    }


    @NonNull
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("当前的数据长度是%d\n队首[",size));
        Node cur = head;
        while (cur!=null){
            str.append(cur.e);
            cur = cur.next;
            if(cur != null)
                str.append(",");
        }
        str.append("]队尾");
        return str.toString();
    }
}
