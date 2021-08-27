package leetcode.linkedlist;

/**
 * @author chengzw
 * @description 链表中倒数第k个节点，https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * <p>
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 * @since 2021/8/27
 */
public class GetKthFromEnd {

    /**
     * 思路：构造快慢指针，这两个指针之间相距k个距离，当快指针走到尾了，慢指针正好在倒数k的位置。
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode solution1(ListNode head, int k) {
        //快指针先走k步
        ListNode fast = head;
        //记录走了几步
        int count = 0;
        while (fast != null) {
            count++;
            //当走了k步，跳出循环
            if (count == k) break;
            fast = fast.next;
        }

        //链表节点不够k
        if (fast == null) return null;

        //快慢指针，快指针走到终点，慢指针正好到倒数第k个位置
        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
