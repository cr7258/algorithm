package leetcode.linkedlist;

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
}
