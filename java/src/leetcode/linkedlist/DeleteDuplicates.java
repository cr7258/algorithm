package leetcode.linkedlist;

/**
 * @author chengzw
 * @description 删除排序链表中的重复元素，https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素只出现一次 。
 * 返回同样按升序排列的结果链表。
 * @since 2021/8/25
 */
public class DeleteDuplicates {

    /**
     * 思路：使用新链表添加元素，每个相同的元素只添加一次，注意这里元素是升序的，比较好判断
     * @param head
     * @return
     */
    public ListNode solution1(ListNode head) {

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
