package mashibing.class06;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 定义比较器，Arrays.sort根据学生的id从小到大排序
 * @author 程治玮
 * @since 2021/1/16 10:39 下午
 */
public class ShowComparator {

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

    //比较器，谁的id大，谁放前
    public static class IdComparator implements Comparator<Student> {
        // 如果返回负数，认为第一个参数应该排在前面
        // 如果返回正数，认为第二个参数应该排在前面
        // 如果返回0，认为谁放前面无所谓

        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }


    public static void printStudents(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].name + ", " + students[i].id + ", " + students[i].age);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("张三", 5, 27);
        Student s2 = new Student("李四", 1, 17);
        Student s3 = new Student("王五", 4, 29);
        Student s4 = new Student("赵六", 3, 9);
        Student s5 = new Student("左七", 2, 34);

        Student[] students = { s1, s2, s3, s4, s5 };
        printStudents(students);
        System.out.println("=======");
        Arrays.sort(students, new IdComparator());
        printStudents(students);
        System.out.println("=======");

    }
}
