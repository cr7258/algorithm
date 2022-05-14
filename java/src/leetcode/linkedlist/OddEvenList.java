package leetcode.linkedlist;

/**
 * @author chengzw
 * @description 奇偶链表，https://leetcode-cn.com/problems/odd-even-linked-list/
 * <p>
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * @since 2021/8/27
 */
public class OddEvenList {

    /**
     * 思路：两个新链表分别添加奇数节点和偶数节点，最后把偶数节点接在奇数节点后面
     *
     * @param head
     * @return
     */
    public static ListNode solution1(ListNode head) {
        if (head == null) return null;
        //添加奇数节点
        ListNode oddHead = new ListNode();
        ListNode oddTail = oddHead;
        //添加偶数节点
        ListNode evenHead = new ListNode();
        ListNode evenTail = evenHead;

        //记录是奇数节点还是偶数节点
        int num = 1;
        ListNode p = head;
        while (p != null) {
            //临时节点记录p
            ListNode tmp = p.next;
            //奇数节点
            if (num % 2 == 1) {
                //切断p指向下一个节点的线
                p.next = null;
                oddTail.next = p;
                oddTail = p;
            } else {  //偶数节点
                p.next = null;
                evenTail.next = p;
                evenTail = p;
            }
            p = tmp;
            num++;
        }
        oddTail.next = evenHead.next;
        return oddHead.next;
    }

    /**
     * 思路：两个指针在一个链表上先后遍历
     * oddHead在1出发，先指向3，然后把oddTail移到3
     * evenHead在2出发，先指向4，然后把evenTail移到4
     * 以此类推
     *
     * @param head
     * @return
     */
    public static ListNode solution2(ListNode head) {
        if (head == null) return null;
        //添加奇数节点
        ListNode oddHead = head;
        ListNode oddTail = oddHead;
        //添加偶数节点，从2位置开始
        ListNode evenHead = head.next;
        ListNode evenTail = evenHead;

        //最后一次循环，偶数节点后面会添加 null
        //1 -> 2 -> 3 -> 4 -> 5
        //偶数节点 2 -> 4 -> null
        while (oddTail.next != null && oddTail.next.next != null) {
            oddTail.next = oddTail.next.next;
            oddTail = oddTail.next;
            evenTail.next = evenTail.next.next;
            evenTail = evenTail.next;
        }
        oddTail.next = evenHead;
        return oddHead;
    }
}
