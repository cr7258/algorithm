package leetcode.linkedlist;

/**
 * @author chengzw
 * @description 环形链表，https://leetcode-cn.com/problems/linked-list-cycle/
 * <p>
 * 给定一个链表，判断链表中是否有环。
 * 进阶：你能用 O(1)（即，常量）内存解决此问题吗？
 * @since 2021/8/28
 */
public class HasCycle {

    /**
     * 思路：Floyd 判圈算法，我们定义两个指针，一快一满。
     * 慢指针每次只移动一步，而快指针每次移动两步。初始时，慢指针在位置 head，而快指针在位置 head.next。
     * 这样一来，如果在移动的过程中，快指针反过来追上慢指针，就说明该链表为环形链表
     * 否则快指针将到达链表尾部，该链表不为环形链表。
     *
     * @param head
     * @return
     */
    public static boolean solution1(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        //快指针要先走一步，避免一开始 slow == fast
        ListNode fast = head.next;
        while (fast != null && fast.next != null & slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //如果快慢指针相遇，说明是环形链表
        if (slow == fast) return true;
        return false;
    }
}
