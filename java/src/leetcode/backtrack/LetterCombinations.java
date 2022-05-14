package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengzw
 * @description 电话号码的字母组合，https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * @since 2021/10/9
 */
public class LetterCombinations {
    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        //特殊情况
        int n = digits.length();
        if (n == 0) return result;
        //把数字先转换成按键上对应的字母
        String[] mappings = new String[10];
        mappings[2] = "abc";
        mappings[3] = "def";
        mappings[4] = "ghi";
        mappings[5] = "jkl";
        mappings[6] = "mno";
        mappings[7] = "pqrs";
        mappings[8] = "tuv";
        mappings[9] = "wxyz";
        backtrack(digits, mappings, 0, new char[n]);
        return result;
    }

    //digits[k] + mappings 确定当前阶段的可选列表
    //k 决策阶段
    //path 路径
    public void backtrack(String digits, String mappings[], int k, char[] path) {
        //结束条件
        if (k == digits.length()) {
            result.add(new String(path));
            return;
        }

        //先得到当前数字对应的按键字母
        String mapping = mappings[digits.charAt(k) - '0'];
        //在按键对应的多个字母中多阶段决策
        for (int i = 0; i < mapping.length(); i++) {
            path[k] = mapping.charAt(i);
            backtrack(digits, mappings, k + 1, path);
            //不用还原，直接覆盖 path 数组上的值
        }
    }
}
