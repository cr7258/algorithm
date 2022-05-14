package learning.class01_02;

public class Code02_EventTimesOddTimes {
    //一个数组中只有有一种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数
    // N^N == 0，奇数次和所有的数都异或一遍，最后的值就是这个数
    public static void printOddTimesNum1(int[] arr){
        int eor = 0;
        for (int i = 0; i < arr.length; i++){
            eor ^= arr[i];
        }
        System.out.println(eor);
    }


    // arr中，有两种数，出现奇数次
    public static void  printOddTimesNum2(int[] arr){

        //得到两个出现奇数次数的数 a^b
        int eor = 0;
        for (int i = 0; i < arr.length; i++){
            eor ^= arr[i];
        }


        //eor最后的结果是 a ^ b ,就是我们要找的两种数
        //a和b不相等，可以得出eor != 0
        //那么eor肯定有一个位置上不为0，那我们就找最右侧的1（哪个位置都可以）
        //1的位置上，说明a和b这个位置上的值是不一样的
        //整个数组可以分成两类，x位是1的数，x位不是1的数，假设a是x位是1的数，b是x位不是1的数
        //只有x为是1的数，异或到eor'，最后eor'就会把a取出来（因为偶数个数都会异或没掉）
        //eor ^ eor' = eor

        // eor最右侧的1，提取出来
        //             eor = 01101110010000
        //     取反   ~eor = 10010001101111
        //   取反+1 ~eor+1 = 10010001110000
        //  eor & (~eor+1) 就可以提取出最右侧的1 , ~eor+1 = -eor


        //获取eor最右侧的1，00000000010000
        int rightOne = eor & (-eor);

        int onlyOne = 0; //eor'
        for (int i = 0; i < arr.length; i++){
            //只有x为是1的数，异或到eor'，最后eor'就会把a取出来（因为偶数个数都会异或没掉）
            //eor ^ eor' = b （eor = a ^ b , eor' = a）
            if ((arr[i] & rightOne) != 0){
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }



    public static void main(String[] args) {
        int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
        printOddTimesNum1(arr1);

        int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
        printOddTimesNum2(arr2);
    }
}
