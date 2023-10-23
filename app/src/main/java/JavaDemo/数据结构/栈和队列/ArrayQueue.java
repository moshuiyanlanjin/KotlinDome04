package JavaDemo.数据结构.栈和队列;

import androidx.annotation.NonNull;

import JavaDemo.数据结构.数组.Array;


public class ArrayQueue<E> implements Queue<E> {

    Array<E> array;
    public ArrayQueue(){
        array = new Array<>();
    }

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.romoveFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("当前的队列内元素总共有%d\n",getSize()));
        str.append("first[");
        for (int i = 0; i < getSize(); i++) {
            str.append(array.get(i));
            if(i < getSize()-1)
                str.append(",");
        }
        str.append("] tail");
        return str.toString();
    }
}
