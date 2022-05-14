package leetcode.queue;

/**
 * @author chengzw
 * @description
 * @since 2022/5/14
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例 1:
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * <p>
 * 示例 2:
 * 输入：s = ""
 * 输出：' '
 * <p>
 * leetcode: https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class FirstUniqChar {
    /**
     * 思路：
     * 1.使用哈希表存储每个字符以及它们第一次出现的位置
     * 2.使用一个额外的队列，按照顺序存储每一个字符以及它们第一次出现的位置
     * 3.当对字符串进行遍历时，如果当前字符不在哈希表中，就将字符和索引作为二元组放入队尾，
     * 否则不断地根据哈希表中存储的值（是否为 -1）选择弹出队首的元素，直到队首元素「真的」只出现了一次或者队列为空。
     *
     * 时间复杂度：O(n)，其中 n 是字符串 s 的长度。遍历字符串的时间复杂度为 O(n)，而在遍历的过程中我们还维护了一个队列，
     * 由于每一个字符最多只会被放入和弹出队列最多各一次，因此维护队列的总时间复杂度为 O(∣Σ∣)，由于 s 包含的字符种类数一定小于 s 的长度，
     * 因此 O(∣Σ∣) 在渐进意义下小于 O(n)，可以忽略。
     *
     * 空间复杂度：O(∣Σ∣)，其中 Σ 是字符集，在本题中 s 只包含小写字母，因此 ∣Σ∣≤26。我们需要 O(∣Σ∣) 的空间存储哈希映射以及队列。
     */
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> position = new HashMap<Character, Integer>();
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (position.containsKey(ch)) {
                position.put(ch, -1);
                while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
                    queue.poll();
                }
            } else {
                position.put(ch, i);
                queue.offer(new Pair(ch, i));
            }
        }
        return queue.isEmpty() ? ' ': queue.poll().ch;
    }
}


class Pair {
    char ch;
    int pos;

    Pair(char ch, int pos) {
        this.ch = ch;
        this.pos = pos;
    }
}

