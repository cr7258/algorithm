package leetcode.linkedlist;

/**
 * @author chengzw
 * @description 反转链表，https://leetcode-cn.com/problems/reverse-linked-list/
 * @since 2021/8/27
 */
public class ReverseList {

    /**
     * 思路：反转操作
     * p.next = newNode
     * newNode = p
     * @param head
     * @return
     */
    public static ListNode solution1(ListNode head){
        ListNode p = head;
        //虚拟头节点
        ListNode newNode = null;

        while(p != null){
            ListNode tmp = p.next;
            p.next = newNode;
            newNode = p;
            p = tmp;
        }

        return newNode;
    }
}
