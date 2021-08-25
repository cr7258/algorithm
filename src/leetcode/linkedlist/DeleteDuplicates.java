package leetcode.linkedlist;

/**
 * @author chengzw
 * @description 删除排序链表中的重复元素，https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @since 2021/8/25
 */
public class DeleteDuplicates {

    public ListNode solution1(ListNode head) {

        //如果头节点为空
        if (head == null) return null;

        //记录当前val，是升序排列的
        int val = -101;

        //新的链表添加不等于 val 的元素，新链表头节点
        ListNode newNode = new ListNode();
        //新链表移动指针
        ListNode tail = newNode;

        //遍历原链表
        ListNode p = head;
        while (p != null) {
            //如果这个元素已经有了，就跳过
            ListNode tmp = p.next;
            if (p.val != val) {
                //val重新赋值
                val = p.val;
                //原链表去掉节点
                p.next = null;
                //新链表添加节点
                tail.next = p;
                tail = p;
            }
            p = tmp;
        }
        return newNode.next;
    }
}
