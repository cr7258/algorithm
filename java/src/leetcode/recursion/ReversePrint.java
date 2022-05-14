package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengzw
 * @description 从尾到头打印链表，https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @since 2021/9/7
 */

/**
 * 思路：递归找链表节点的值，用全局变量添加 head.val
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class ReversePrint {
    List<Integer> list = new ArrayList();

    public int[] reversePrint(ListNode head) {
        reversePrint_r(head);

        //ArrayList 转为数组
        int[] result = new int[list.size()];
        int i = 0;
        for (int k : list) {
            result[i++] = k;
        }
        return result;
    }

    public void reversePrint_r(ListNode head) {
        if (head == null) return;
        reversePrint_r(head.next);
        list.add(head.val);
    }
}
