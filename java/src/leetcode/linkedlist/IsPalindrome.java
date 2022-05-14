package leetcode.linkedlist;

/**
 * @author chengzw
 * @description 回文链表，https://leetcode-cn.com/problems/palindrome-linked-list/
 * <p>
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * @since 2021/8/27
 */
public class IsPalindrome {

    /**
     * 思路：首先找到中间节点，然后反转中间节点右边的链表，再比较左边和右边是否相等。
     *
     * @param head
     * @return
     */
    public static boolean solution1(ListNode head) {
        //特殊情况
        if (head == null || head.next == null) return true;

        //主逻辑
        //先找到链表中点
        ListNode midNode = findMidNode(head);
        //反转中点后的链表
        ListNode reverseNode = reverseList(midNode);

        //比较原链表中点前的一半和反转后的另一半链表
        ListNode p = head;
        ListNode q = reverseNode;
        while (q != null) {
            if (p.val != q.val) return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }

    //找到中点，快慢指针
    public static ListNode findMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //反转链表
    public static ListNode reverseList(ListNode midNode) {
        ListNode newNode = null;
        ListNode p = midNode;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = newNode;
            newNode = p;
            p = tmp;
        }
        return newNode;
    }
}
