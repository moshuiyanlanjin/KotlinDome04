package JavaDemo.数据结构.二分搜索树;

public class BSTMain {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] list = new int[]{5,3,6,8,4,2};
        for (int i = 0; i < list.length; i++) {
            bst.add(list[i]);
        }

     //   bst.preOrder();
        //bst.inOrder();
      //  System.out.println(bst.toString());
        bst.preOrderNR();
    }
}
