package JavaDemo.数据结构.栈和队列;

public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    //拿出栈顶数据，并展示
    E pop();

    //获取栈顶的数据
    E peek();
}
