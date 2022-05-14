package leetcode.binary_search;

/**
 * @author chengzw
 * @description 稀疏数组搜索，https://leetcode-cn.com/problems/sparse-array-search-lcci/
 *
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 *
 *  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 *  输出：-1
 *  说明: 不存在返回-1。
 *
 *  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 *  输出：4
 *
 * @since 2021/9/17
 */

/**
 * 思路：
 * 1.当 mid 是字符串时，正常二分
 * 2.当 mid 是 "" 时，从 low 或者 high 一步一步缩小范围
 */
public class FindString {
    public int findString(String[] words, String s) {
        int low = 0;
        int high = words.length - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(words[mid].equals(s)){
                return mid;
            }else if(words[mid].equals("")){
                //这里用high也行
                if(words[low].equals(s)) return low;
                else low ++;
            }else if(words[mid].compareTo(s) < 0){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
