package JavaDemo.数据结构.栈和队列;

public class StarkMain {

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }

        System.out.println(arrayStack.pop());


    }
}
