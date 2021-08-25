package leetcode.linkedlist;

import java.util.List;

/**
 * @author chengzw
 * @description 链表的中间节点，https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * @since 2021/8/25
 */
public class MiddleNode {

    /**
     * 思路：快慢指针，快指针一次走2步，慢指针一次走1步，当快指针到终点时，慢指针正好到中间节点
     * @param head
     * @return
     */
    public static ListNode solution1(ListNode head) {
        //快慢指针
        ListNode slow = head;
        ListNode fast = head;

        //遍历链表，注意空指针
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
