package leetcode.linkedlist;

/**
 * @author chengzw
 * @description 相交链表，https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * <p>
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构。
 * @since 2021/8/28
 */
public class GetIntersectionNode {

    /**
     * 思路：
     * 1.分别计算a链表和b链表的长度
     * 2.让长度长的链表先走差值
     * 3.然后两个指针一起走，遇到相等的节点就是第一个相交的节点
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode solution1(ListNode headA, ListNode headB) {

        //计算链表a的长度
        int lengthA = 0;
        ListNode pa = headA;
        while (pa != null) {
            lengthA++;
            pa = pa.next;
        }

        //计算链表b的长度
        int lengthB = 0;
        ListNode pb = headB;
        while (pb != null) {
            lengthB++;
            pb = pb.next;
        }

        //长的链表的指针先走差值步
        pa = headA;
        pb = headB;
        if (lengthA >= lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                pa = pa.next;
            }
        } else {
            for (int i = 0; i < lengthB - lengthA; i++) {
                pb = pb.next;
            }
        }

        //两个链表一起走
        while (pa != null && pb != null) {
            if (pa == pb) return pa;
            pa = pa.next;
            pb = pb.next;
        }

        return null;
    }
}
