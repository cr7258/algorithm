package leetcode.linkedlist;

/**
 * @author chengzw
 * @description 删除链表的倒数第N个节点，https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * @since 2021/8/27
 */
public class RemoveNthFromEnd {

    /**
     * 思路：
     * 1.快慢指针，快指针先走n步，然后快慢指针一起走，快指针走到尾部，慢指针正好走到第n个
     * 2.用一个prev记录慢指针的前一个节点，最后使用prev.next = slow.next 跳过第n个节点
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode solution1(ListNode head, int n) {
        //快指针先走n步
        ListNode fast = head;
        int count = 0;
        while (fast != null) {
            count++;
            if (count == n) break;
            fast = fast.next;
        }

        //不够k个
        if (fast == null) return null;

        //慢指针
        ListNode slow = head;
        //记录慢指针的前一个节点
        ListNode prev = null;
        while (fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        //如果头节点是倒数第n个节点
        if (prev == null) {
            head = head.next;
        } else {
            prev.next = slow.next;
        }
        return head;
    }
}
