package JavaDemo.数据结构.二分搜索树;

import JavaDemo.数据结构.栈和队列.ArrayStack;
import JavaDemo.数据结构.栈和队列.Stack;

public class BST<E extends Comparable<E>> {

    private class Node{
        private E e;

        private Node right,left;

        public Node (E e){
            this.e = e;
            right = null;
            left = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){

        root = add(root,e);

    }

    private Node add(Node node,E e){

        if(node == null){
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0){
            node.left = add(node.left,e);
        }else
            node.right = add(node.right,e);

        return node;
    }

    //看二分搜索树中是否包含此元素
    private boolean contains(E e){
        return contains(root,e);
    }


    //看二分搜索树是否在此节点下包含此元素

    private boolean contains(Node node,E e){
        if(node == null){
            return false;
        }

        if(e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }else if (e.compareTo(node.e) > 0){
            return contains(node.right,e);
        }else{
            return true;
        }
    }


    //二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null){
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }


    //二分搜索树的前序遍历，不用递归
    public void preOrderNR(){
        ArrayStack<Node> stack = new ArrayStack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            Node pop = stack.pop();
            System.out.println(pop.e);

            if(pop.left!=null){
                stack.push(pop.left);
            }

            if (pop.right !=null)
                stack.push(pop.right);
        }
    }


    //二分搜索树的中序遍历
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null){
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二分搜索树的后序遍历

    public void traveres(){
        traveres(root);
    }

    private void traveres(Node node) {

        if(node == null){
            return;
        }

        traveres(node.left);
        traveres(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString() {
       StringBuilder stringBuilder = new StringBuilder();
       generateBstString(root,0,stringBuilder);

       return stringBuilder.toString();
    }

    private void generateBstString(Node node, int path, StringBuilder stringBuilder) {

        if(node == null){
            stringBuilder.append(gengrateDataPath(path) + "null\n");
            return;
        }
        stringBuilder.append(gengrateDataPath(path)+ node.e + "\n");
        generateBstString(node.left,path+1,stringBuilder);
        generateBstString(node.right,path+1,stringBuilder);
    }

    private String gengrateDataPath(int path) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < path; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
