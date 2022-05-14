package leetcode.linkedlist;

/**
 * @author chengzw
 * @description 链表的中间节点，https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
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
