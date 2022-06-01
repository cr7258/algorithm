package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author chengzw
 * @description 删除字符串中的所有相邻重复项，https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 * <p>
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
 * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * @since 2021/9/6
 */
public class RemoveDuplicates {

    /**
     * 思路1：遇到相同的就弹出栈顶消除
     *
     * @param s
     * @return
     */
    public static String solution1(String s) {
        Deque<Character> deque = new LinkedList<>();
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if(deque.isEmpty() || deque.peekLast() != c){
                deque.addLast(c);
            }else{
                deque.pollLast();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution1("abbaca"));
    }
}
