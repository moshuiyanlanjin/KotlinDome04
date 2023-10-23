package JavaDemo.数据结构.栈和队列;

/**
 * 循环队列
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front,tail,size;//队首，队尾，队列总长度

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity + 1];//循环队列中要有意识空掉一个元素，保证正常情况下front == tail
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if((tail + 1) % data.length == front){
            reSize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }



    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("当前数据为空");
        }
        E eat = data[front];
        data[front] = null;
        size--;
        front = (front + 1)%data.length;
        if(size == getCapacity() / 4 && getCapacity()/2 !=0){
            reSize(getCapacity()/2);
        }
        return eat;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("当前数据为空");
        }
        return  data[0];
    }

    private void reSize(int capacity) {
        E[] newData = (E[])new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
      //      System.out.println(String.format("当前的i=%d,front = %d, capacity = %d",i,front,capacity));
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("当前的队列内元素总共有%d\n",getSize()));
        str.append("first[");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            str.append(data[i]);
            if((i + 1)%data.length != tail)
                str.append(",");
        }
        str.append("] tail");
        return str.toString();
    }
}
