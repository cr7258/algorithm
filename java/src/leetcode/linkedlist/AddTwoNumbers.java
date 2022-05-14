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

    /**
     * 思路：
     * 1.分别遍历两个链表，用两个数组分别记录每个链表每位的值。
     * 2.然后将数组转换成数字相加得到和。
     * 3.用新的链表添加元素。
     *
     * int表示范围是:
     * -2^31 ~ 2^31-1 也就是 -2147483648 ~ 2147483647，超过这个范围的数字会有异常
     *
     * @param l1
     * @param l2
     * @return
     */
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
        //总和
        int sum = val1 + val2;
        //特殊情况
        if (sum == 0) {
            return new ListNode(0);
        }
        //虚拟头节点
        ListNode newNode = new ListNode();
        ListNode tail = newNode;
        while (sum > 0) {
            ListNode node = new ListNode(sum % 10);
            tail.next = node;
            tail = node;
            sum /= 10;
        }
        return newNode.next;
    }


    /**
     * 思路：两个指针分别遍历两个链表，遍历时候按位相加，满10进1
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode solution2(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;

        //存放结果的新链表
        ListNode newHead = new ListNode();
        ListNode tail = newHead;

        //进位
        int carry = 0;
        while (p1 != null || p2 != null) {
            //当前位两数相加的和
            int sum = 0;
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }

            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }

            sum += carry;
            //进位
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
        }

        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            tail.next = newNode;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head1 = ListNode.createNode(new int[]{2, 3, 4});
        ListNode head2 = ListNode.createNode(new int[]{5, 6, 4});
        ListNode result1 = solution1(head1, head2);
        System.out.println(ListNode.printNode(result1));
        ListNode result2 = solution2(head1, head2);
        System.out.println(ListNode.printNode(result2));

        ListNode head3 = ListNode.createNode(new int[]{9});
        //int表示范围是:
        //-2^31 ~ 2^31-1 也就是 -2147483648 ~ 2147483647，超过这个范围的数字solution1会有异常
        ListNode head4 = ListNode.createNode(new int[]{1,9,9,9,9,9,9,9,9,9});
        ListNode result3 = solution1(head3, head4);
        System.out.println(ListNode.printNode(result3));
        ListNode result4 = solution2(head3, head4);
        System.out.println(ListNode.printNode(result4));
    }

}
