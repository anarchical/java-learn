import java.util.Stack;

/**
 * @author YeYaqiao
 */
public class Test {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution solution = new Solution();
        solution.reverseList(head);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {


        Stack<ListNode> stack = new Stack<>();

        ListNode currentNode = head;
        while (currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.next;
        }

        ListNode pointer = stack.pop();
        ListNode result = pointer;

        while (!stack.isEmpty()) {

            pointer.next = stack.pop();
            pointer = pointer.next;
        }

        pointer.next = null;

        return result;
    }


}