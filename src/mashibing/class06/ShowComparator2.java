package mashibing.class06;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**优先级队列使用自定义比较器
 * @author 程治玮
 * @since 2021/1/16 10:46 下午
 */
public class ShowComparator2 {

    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }



    //整型比较器
    public static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }


    // 学生id比较器 谁id大，谁放前！
    public static class IdComparator implements Comparator<Student> {

        // 如果返回负数，认为第一个参数应该排在前面
        // 如果返回正数，认为第二个参数应该排在前面
        // 如果返回0，认为谁放前面无所谓
        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }

    public static void main(String[] args) {
        //默认优先级队列是小根堆，通过自定义比较器改成大根堆
        PriorityQueue<Integer> heap1 = new PriorityQueue<>(new MyComparator());
        heap1.add(6);
        heap1.add(2);
        heap1.add(3);
        heap1.add(1);
        heap1.add(7);
        System.out.println("========");
        while (!heap1.isEmpty()) {
            System.out.println(heap1.poll());
        }


        PriorityQueue<Student> heap2 = new PriorityQueue<>(new IdComparator());
        Student s1 = new Student("张三", 5, 27);
        Student s2 = new Student("李四", 1, 17);
        Student s3 = new Student("王五", 4, 29);
        Student s4 = new Student("赵六", 3, 9);
        Student s5 = new Student("左七", 2, 34);
        heap2.add(s1);
        heap2.add(s2);
        heap2.add(s3);
        heap2.add(s4);
        heap2.add(s5);
        System.out.println("=========");
        while (!heap2.isEmpty()) {
            Student s = heap2.poll();
            System.out.println(s.name + ", " + s.id + ", " + s.age);
        }


        System.out.println("=========");
        TreeSet<Student> treeSet = new TreeSet<>(new IdComparator());
        treeSet.add(s1);
        treeSet.add(s2);
        treeSet.add(s3);
        treeSet.add(s4);
        treeSet.add(s5);
        while (!treeSet.isEmpty()){
            Student s = treeSet.pollFirst();
            System.out.println(s.name + ", " + s.id + ", " + s.age);
        }
    }
}
