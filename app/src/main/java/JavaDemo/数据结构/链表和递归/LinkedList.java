package JavaDemo.数据结构.链表和递归;

import androidx.annotation.NonNull;

public class LinkedList<E> {

    private class Node{
        public E e;
        //下一条Node
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    //链表的虚拟表头表头,在链表前添加一个虚拟的表头，相当于永远空出一个表头，方便表头添加数据时可以直接添加
    private Node dummyhead;
    private int size;

    public LinkedList(){
        dummyhead = new Node(null,null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    /**
     * 向指定下标添加数据
     * @param index 下标，索引
     * @param e 添加的元素
     *    链表是线性结构（个人理解：所有数据用一条线链接起来）
     *     所以想要在指定的索引添加数据需要先拿到这个索引的前一个数据，通过索引的前一个数据拿到当前索引的数据，并将此数据
     *      关联需要加入的元素（即将索引指向的数据设置为需要添加的元素的下一个数据），然后在将所要添加数据关联为索引前一个数据的下一个数据
     *       ，整个链表到此关联成功（具体参考给火车中间添加车厢）
     */
    public void add(int index,E e){
        if(index<0 || index > size){
            throw new IllegalArgumentException("数据超界");
        }

            //pev索引的前一个数据
            Node pev = dummyhead;
            for (int i = 0; i < index; i++) {
                pev = pev.next;
            }

            //将索引指向的数据设为所要添加元素的下一个数据，形成数据链表后，将添加的元素设为索引前一个数据的下一个数据，关联成功
            pev.next = new Node(e,pev.next);

            size++;

    }
    public void addFirst(E e){
      /*  Node node = new Node(e);
        node.next = head;
        head = node;*/
       /* head = new Node(e,head);
        size++;*/
        add(0,e);
    }

    /**
     * 在链表的末尾添加数据
     * @param e
     */
    public void addLast(E e){
        add(size - 1,e);
    }


    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("数据超限");
        }
        Node div = dummyhead.next;
        for (int i = 0; i < index; i++) {
            div = div.next;
        }

        return div.e;
    }

    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }

    public void set(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("数据超限");
        }

        Node div = dummyhead.next;

        for (int i = 0; i < index; i++) {
            div = div.next;
        }
        div.e = e;
    }

    public void setLast(E e){
        set(size-1,e);
    }

    public void setFirst(E e){
        set(0,e);
    }

    /**
     * 判断当前链表是否有此元素
     * @param e
     * @return
     */
    public boolean contains(E e){
        Node car = dummyhead.next;
        while (car != null){
            if(car.e.equals(e)){
                return true;
            }
            car = car.next;
        }
        return false;
    }

    public E remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("数据超限");
        }
        Node cur = dummyhead;
        //拿到要删除元素的前一个元素
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        //拿到要删除的元素
        Node docur = cur.next;
        //将删除元素的前一个元素关联删除元素的后一个元素
        cur.next = docur.next;
        docur.next = null;
        size--;
        return docur.e;
    }

    public E removeLast(){

        return remove(size - 1);
    }

    public E removeFirst(){
        return remove(0);
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append(String.format("当前的链表的长度是:%d\n",size) + "[");
        Node cur = dummyhead.next;
        for (int i = 0; i < size; i++) {
            strb.append(cur.e);
            cur = cur.next;
            if(i != size - 1)
                strb.append(",");
        }
        strb.append("]");
        return strb.toString();
    }
}
