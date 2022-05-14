package leetcode.recursion;

/**
 * @author chengzw
 * @description 反转链表，https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @since 2021/9/7
 */
public class ReverseList {
    /**
     * 思路1：递归解法，把反转问题分解成子链表的反转
     * 时间复杂度：O(n)，递归树的节点数，链表的长度
     * 空间复杂度：O(n)，递归树的高度
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //递归终止条件
        //空节点
        if (head == null) return null;
        //1个节点的情况
        if (head.next == null) return head;
        //先reverse 得到 5->4->3->2<-1
        ListNode newHead = reverseList(head.next);
        //反转，1->2 变为 2<-1
        head.next.next = head;
        //节点自身指向 null
        head.next = null;
        return newHead;
    }
}
