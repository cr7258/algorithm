package mashibing.class06;

/**
 * @author 程治玮
 * @since 2021/1/19 10:16 下午
 * <p>
 * 先序，中序，后续遍历二叉树
 *
 *         1
 *      2     3
 *    4   5  6   7
 */

public class TraversalBinary {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    //先序
    public static void pre(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    //中序
    public static void in(Node head) {
        if (head == null) {
            return;
        }

        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }


    //后续
    public static void pos(Node head) {
        if (head == null) {
            return;
        }

        pos(head.left);
        pos(head.right);
        System.out.println(head.value);
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        pre(head);
        System.out.println("========");
        in(head);
        System.out.println("========");
        pos(head);
        System.out.println("========");

    }


}
