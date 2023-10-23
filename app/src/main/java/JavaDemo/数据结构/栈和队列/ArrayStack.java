package JavaDemo.数据结构.栈和队列;


import JavaDemo.数据结构.数组.Array;

public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capaicty){
        array = new Array(capaicty);
    }

    public ArrayStack(){
        array = new Array();
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
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(String.format("当前的站内元素总共有%d\n",getSize()));
        str.append("[");
        for (int i = 0; i < getSize(); i++) {
            str.append(array.get(i));
            if(i < getSize()-1)
                str.append(",");
        }
        str.append("] Top");
        return str.toString();
    }
}
