package mashibing.class06;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 程治玮
 *  @since 2021/1/16 11:09 下午
 * 合并K个升序链表 测试链接：https://leetcode.com/problems/merge-k-sorted-lists/
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 时间复杂度O(N*logM),总共进入小根堆N次，小根堆节点最大数量M（小根堆重新排序的复杂度为logM）
 */
public class Code01_MergeKSortedLists {
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static class ListNodeComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {


        //1.把各个链表的头节点放入优先级队列（小根堆）
        if(lists==null){
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
        for(int i=0;i<lists.length;i++){
            if(lists[i] !=null){
                heap.add(lists[i]);
            }
        }
        if(heap.isEmpty()){
            return null;
        }

        //2.弹出在小根堆中最小的节点，加入新的链表中，然后把该节点next指针的值加入小根堆
        ListNode head = heap.poll();
        ListNode pre  = head;
        if(pre.next !=null){
            heap.add(pre.next);
        }

        while (!heap.isEmpty()){
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if(cur.next !=null){
                heap.add(cur.next);
            }
        }
        return head;
    }


}
