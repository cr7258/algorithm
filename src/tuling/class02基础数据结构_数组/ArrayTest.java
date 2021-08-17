package tuling.class02基础数据结构_数组;

/**
 * 实现ArrayList基本方法
 *
 * @author 程治玮
 * @since 2021/5/5 9:29 下午
 */
public class ArrayTest {

    //数组长度
    private int size;
    //数组
    private int data[];
    //已存的数据长度
    private int index;

    public ArrayTest(int size){ //数组的初始化过程
        this.size = size;
        data = new int[size]; //分配的堆内存空间
        index = 0;
    }

    //打印数组信息
    public void print() {
        System.out.println("已存的数据长度为: " + index);
        for (int i = 0; i < index; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    //添加元素，时间复杂度O(n)
    //增加元素时，该元素后面的元素先需要后移
    public void insert(int loc, int value) {
        for (int i = size - 1; i > loc; i--) {
            data[i] = data[i-1];
        }
        //后移完成后再给该位置赋上新元素的值
        data[loc] = value;
        index ++;
    }

    //删除元素，时间复杂度O(n)
    //删除元素时，该元素后面的元素要前移
    public void delete(int loc,int value){
        for(int i = loc; i < size - 2; i ++){
            data[i] = data[i+1];
        }
        data[size-1] = 0; //最后的元素赋值为0，表示删除
        index --;
    }

    //修改元素，时间复杂度O(1)
    public void update(int loc,int value){
        data[loc] = value;
    }

    //查找元素，时间复杂度O(1)
    public int get(int loc){
        return data[loc];
    }

    public static void main(String[] args) {
        ArrayTest arrayTest = new ArrayTest(10);
        arrayTest.print();
        System.out.println("=====插入数据=====");
        arrayTest.insert(0,0);
        arrayTest.insert(1,1);
        arrayTest.insert(2,2);
        arrayTest.print();
        System.out.println("=====删除数据======");
        arrayTest.delete(1,1);
        arrayTest.print();
        System.out.println("=====修改数据======");
        arrayTest.update(0,3);
        arrayTest.print();
        System.out.println("=====查找数据======");
        System.out.println(arrayTest.get(1));
    }
}
