package JavaDemo.数据结构.栈和队列;

public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    //向数组末尾添加数据（队列只能先进先出）
    void enqueue(E e);
    //删除并拿到被删除的元素
    E dequeue();
    //
    E getFront();

}
