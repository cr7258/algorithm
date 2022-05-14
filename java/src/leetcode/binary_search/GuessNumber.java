package leetcode.binary_search;

/**
 * @author chengzw
 * @description 猜数字大小，https://leetcode-cn.com/problems/guess-number-higher-or-lower/
 * @since 2021/9/14
 */

//public class GuessNumber {
//    public int guessNumber(int n) {
//        int low = 0;
//        int high = n;
//        while(low <= high){
//            int mid = low + (high - low)/2;
//            int result = guess(mid);
//            if(result == 0){
//                return mid;
//            }else if(result == -1){
//                high = mid - 1;
//            }else{
//                low = mid + 1;
//            }
//        }
//        return -1;
//    }
//}
