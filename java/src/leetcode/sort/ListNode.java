package leetcode.sort;

/**
 * @author chengzw
 * @description 链表结构
 * @since 2021/8/25
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createNode(int[] num) {
        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        for (int i = 0; i < num.length; i++) {
            tail.next = new ListNode(num[i]);
            tail = tail.next;
        }
        return newHead.next;
    }

    public static String printNode(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode p = head;
        while (p != null){
            sb.append(p.val);
            sb.append(" -> ");
            p = p.next;
        }
        return sb.substring(0,sb.length()-4).toString();
    }
}


