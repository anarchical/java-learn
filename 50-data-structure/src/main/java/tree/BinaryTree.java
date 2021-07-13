package tree;

/**
 * @author YeYaqiao
 * 二叉树定义（手写一个二叉树，实现前序遍历、中序遍历、后序遍历）
 */
public class BinaryTree {

//    private Node root;
//
//    public void setRoot(Node root) {
//        this.root = root;
//    }
//
//    public void perOrder() {
//        if (this.root != null) {
//            this.root.perOrder();
//        } else {
//            System.out.println("二叉树为空");
//        }
//    }
//
//    public void infixOrder() {
//        if (this.root != null) {
//            this.root.infixOrder();
//        } else {
//            System.out.println("二叉树为空");
//        }
//    }
//
//    public void postOrder() {
//        if (this.root != null) {
//            this.root.postOrder();
//        } else {
//            System.out.println("二叉树为空");
//        }
//    }
//
//
//    public static void main(String[] args) {
//        BinaryTree binaryTree = new BinaryTree();
//
//        Node root = new Node(1, "节点1号");
//        Node node2 = new Node(2, "节点2号");
//        Node node3 = new Node(3, "节点3号");
//        Node node4 = new Node(4, "节点4号");
//
//        root.setLeft(node2);
//        root.setRight(node3);
//        node3.setRight(node4);
//        binaryTree.setRoot(root);
//
//        System.out.println("前序遍历");
//        binaryTree.perOrder();
//
//        System.out.println("中序遍历");
//        binaryTree.infixOrder();
//
//        System.out.println("后序遍历");
//        binaryTree.postOrder();
//    }

}


//class Node<K,V> {
//
//    private int num;
//    private String value;
//    private Node left;
//    private Node right;
//
//    public Node(int num, String value) {
//        this.num = num;
//        this.value = value;
//    }
//
//    public int getNum() {
//        return num;
//    }
//
//    public void setNum(int num) {
//        this.num = num;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
//
//    public Node getLeft() {
//        return left;
//    }
//
//    public void setLeft(Node left) {
//        this.left = left;
//    }
//
//    public Node getRight() {
//        return right;
//    }
//
//    public void setRight(Node right) {
//        this.right = right;
//    }
//
//    @Override
//    public String toString() {
//        return "Node{" +
//                "num=" + num +
//                ", value='" + value + '\'' +
//                '}';
//    }
//
//    /**
//     * 前序遍历
//     */
//    public void perOrder() {
//        System.out.println(this);
//        if (this.left != null) {
//            this.left.perOrder();
//        }
//        if (this.right != null) {
//            this.right.perOrder();
//        }
//    }
//
//    /**
//     * 中序遍历
//     */
//    public void infixOrder() {
//        if (this.left != null) {
//            this.left.perOrder();
//        }
//        System.out.println(this);
//        if (this.right != null) {
//            this.right.perOrder();
//        }
//    }
//
//    /**
//     * 后序遍历
//     */
//    public void postOrder() {
//        if (this.left != null) {
//            this.left.perOrder();
//        }
//        if (this.right != null) {
//            this.right.perOrder();
//        }
//        System.out.println(this);
//    }
//}

class Node<K,V>{

    private K key;
    private V value;
    private Node left;
    private Node right;


}