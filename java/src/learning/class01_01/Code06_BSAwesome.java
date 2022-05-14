package learning.class01_01;

public class Code06_BSAwesome {
    //局部最小值问题，只返回一个局部最小值，比左边小也比右边小
    //无序数组，二分不一定要有序，数据状况比较特殊
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        //如果只有数组只有1个值，或者0位置比1位置小
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        //如果最右边的比倒数第二个小
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        //当不满足以上条件时，在中间肯定存在一个下降的地方，因为左右两边都是大的
        int L = 1;
        int R = arr.length - 2;
        int mid  = 0;
        while (L < R) {
            mid = (L + R) / 2;
            if (arr[mid] > arr[mid - 1]) { //如果中间值比左边的值大，则向左找
                R = mid - 1;
            } else if (arr[mid] <= arr[mid + 1]) {
                return mid;
            } else {
                L = mid + 1;
            }
        }
        return L;
    }


    public static int test(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // no exist
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    //   ######################### 对数器 ###################################
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        int testTime = 500000;
        for (int i = 1; i <= testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int result1 = getLessIndex(arr);
            int result2 = test(arr);
            if (result1 != result2) {
                printArray(arr);
                System.out.println(result1);
                System.out.println(result2);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
