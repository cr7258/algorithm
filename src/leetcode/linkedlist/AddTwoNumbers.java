package leetcode.linkedlist;

/**
 * @author chengzw
 * @description 两数相加，https://leetcode-cn.com/problems/add-two-numbers/
 * <p>
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * @since 2021/8/26
 */
public class AddTwoNumbers {

    public static ListNode solution1(ListNode l1, ListNode l2) {

        //分别遍历两个链表的数字，逆序生成真正的数值
        int val1 = 0;
        int[] val1Num = new int[100];
        int i = 0;
        while (l1 != null) {
            val1Num[i] = l1.val;
            i++;
            l1 = l1.next;
        }
        while (i > 0) {
            val1 = val1 * 10 + val1Num[i - 1];
            i--;
        }


        int val2 = 0;
        int[] val2Num = new int[100];
        int j = 0;
        while (l2 != null) {
            val2Num[j] = l2.val;
            j++;
            l2 = l2.next;
        }
        while (j > 0) {
            val2 = val2 * 10 + val2Num[j - 1];
            j--;
        }

        //返回新的链表
        int sum = val1 + val2;
        ListNode newNode = new ListNode();
        ListNode tail = newNode;
        while (sum > 0) {
            tail.val = sum % 10;
            ListNode node = new ListNode();
            tail.next = node;
            tail = node;
            sum /= 10;
        }
        //最后节点指向null
        tail = null;
        return newNode;
    }


}
