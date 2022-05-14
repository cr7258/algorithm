package leetcode.hashtable;

/**
 * @author chengzw
 * @description 环形链表，https://leetcode-cn.com/problems/linked-list-cycle/
 * 给定一个链表，判断链表中是否有环。
 * @since 2021/9/20
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 思路：
 *  遍历节点的时候在哈希表中找，如果不存在存入哈希表，如果存在则表示有环
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> hashSet = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (hashSet.contains(p)) return true;
            hashSet.add(p);
            p = p.next;
        }
        return false;
    }
}
