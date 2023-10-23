package JavaDemo.数据结构.链表和递归;

import androidx.annotation.NonNull;

import JavaDemo.数据结构.栈和队列.Stack;


public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @NonNull
    @Override
    public String toString() {
        return list.toString();
    }
}
