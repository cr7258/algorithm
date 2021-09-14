package leetcode.binary_search;

/**
 * @author chengzw
 * @description 寻找比目标字母大的最小字母，https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 *
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 *
 * @since 2021/9/14
 */
public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int n = letters.length - 1;
        int high = n;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(letters[mid] == target){
                if(mid +1 < n && letters[mid + 1] != target) return letters[mid + 1];
                else low = mid + 1;
            }else if(letters[mid] > target){
                if(mid - 1 >= 0 && letters[mid-1] <= target) return letters[mid];
                else high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return letters[0];
    }
}
