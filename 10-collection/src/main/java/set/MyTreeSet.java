package set;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author YeYaqiao
 * 用于存储唯一的，有序的元素，元素必须继承 Comparable 接口具有排序功能
 * TreeMap 每次存入元素时，会将调用当前元素的 compareTo() 与集合中的其他元素作比较
 * 如 A.compareTo(B)
 * -1： A < B
 * 0： A = B
 * 1： A > B
 */
public class MyTreeSet {

    public static void main(String[] args) {

        Set<Node> treeSet = new TreeSet<>();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        treeSet.add(node3);
        treeSet.add(node2);
        treeSet.add(node1);

        System.out.println(treeSet);
    }
}

//存储元素需要继承 Comparable 实现 compareTo 方法
class Node implements Comparable<Node> {

    public int value;

    public Node(int value) {
        this.value = value;
    }

    //规定排序规则
    //返回 -1表示小于，0表示等于，1表示大于
    @Override
    public int compareTo(Node o) {
        if (this.value < o.value) {
            return -1;
        } else if (this.value == o.value) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
