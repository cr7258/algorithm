package leetcode.hashtable;

/**
 * @author chengzw
 * @description 相交链表，https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * @since 2021/9/20
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 思路：
 * 遍历节点的时候在哈希表中找，如果不存在存入哈希表，如果存在返回相交节点
 * <p>
 * 时间复杂度 O(n)
 * 空间复杂度 O(n)
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> hashSet = new HashSet<>();
        ListNode p = headA;
        while (p != null) {
            hashSet.add(p);
            p = p.next;
        }
        ListNode pB = headB;
        while (pB != null) {
            if (hashSet.contains(pB)) return pB;
            pB = pB.next;
        }
        return null;
    }
}