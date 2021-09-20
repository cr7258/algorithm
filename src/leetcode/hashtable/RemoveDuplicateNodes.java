package leetcode.hashtable;

/**
 * @author chengzw
 * @description 移除重复节点，https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 * <p>
 * 移除未排序链表中的重复节点。保留最开始出现的节点。
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * @since 2021/9/20
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 思路：
 * 使用哈希表保存元素，如果元素已经在哈希表中存在，则跳过
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class RemoveDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {
        //特殊情况
        if(head == null) return head;
        Set<Integer> hashSet = new HashSet<>();
        //结果链表
        ListNode newHead = new ListNode();
        ListNode tail = newHead;

        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
            if (!hashSet.contains(p.val)) {
                p.next = null;
                hashSet.add(p.val);
                tail.next = p;
                tail = p;
            }
            p = tmp;
        }
        return newHead.next;
    }
}
