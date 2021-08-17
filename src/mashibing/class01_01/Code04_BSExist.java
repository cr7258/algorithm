package mashibing.class01_01;

import java.util.Arrays;

public class Code04_BSExist {
    //在一个有序数组中，找某个数是否存在

    // #########################  实现方法a  #########################
    public static boolean exist(int[] sortedArr, int num){
        if(sortedArr == null || sortedArr.length == 0){
            return false;
        }

        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;

        // L..R
        while (L < R){  // L..R 至少两个数的时候
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == num){
                return true;
            }
            if (sortedArr[mid] > num){
                R = mid - 1 ;
            }else {
                L = mid + 1;
            }
        }
        //二分到最后的那个值也要判断一下，这里要用L
        //因为如果num小于最小的数组中最小的数，最后一轮：mid=1,L=0,R=1，mid=(0+0.5)/2=0，R=0-1最后R会是-1，导致数组越界
        //当num大于数组中最大的数则没有这个问题，因为while一开始是判断L<R的
        return sortedArr[L] == num;
    }


    // #########################  实现方法b  #########################
    public static boolean test(int[] sortedArr, int num){
        for (int i = 0; i < sortedArr.length; i++){
            if (num == sortedArr[i]){
                return true;
            }
        }
        return false;
    }

    //   ######################### 对数器 ###################################
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr); //有序数组
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != exist(arr, value)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

}
