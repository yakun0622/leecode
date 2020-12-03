package linked_add;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 */
class Solution {
    private int flag = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = parseToStack(l1);
        Stack<Integer> stack2 = parseToStack(l2);

        ListNode result = null;
        ListNode tmp = result;
        Integer addRes = 0;

        // 获取最大长度
        int maxSize = stack1.size() >= stack2.size() ? stack1.size() : stack2.size();
        for (int i = 0; i < maxSize; i++) {
            Integer value1 = 0;
            Integer value2 = 0;
            if (!stack1.empty()) {
                value1 = stack1.pop();
            }
            if (!stack2.empty()) {
                value2 = stack2.pop();
            }
            addRes = value1 + value2 + flag;
            flag = 0;
            if (addRes > 9) {
                flag = 1;
            }
            if (tmp == null) {
                tmp = new ListNode(addRes % 10);
            } else {
                tmp.next = new ListNode(addRes % 10);
            }
            tmp = tmp.next;
        }
        StringBuilder str = new StringBuilder(result.val);
        ListNode tmp1 = result;
        while (hasNext(tmp1)) {
            tmp1 = tmp.next;
            str = str.append(" ").append(tmp1.next.val);
        }
        System.out.println("11111");
        System.out.println(str.toString());
        return result;
    }

    private Stack<Integer> parseToStack(ListNode node) {
        Stack<Integer> stack = new Stack<>();
        ListNode tmp = node;
        stack.push(tmp.val);
        while (hasNext(tmp)) {
            tmp = tmp.next;
            stack.push(tmp.val);
        }
        return stack;
    }

    private boolean hasNext(ListNode node) {
        return node.next != null;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = solution.addTwoNumbers(l1, l2);
    }
}