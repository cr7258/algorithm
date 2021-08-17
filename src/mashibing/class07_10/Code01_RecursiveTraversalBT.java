package mashibing.class07_10;


/**
 * 递归方式二叉树的先序、中序、后序遍历
 * 先序：任何子树的处理顺序都是，先头节点、再左子树、然后右子树
 * 中序：任何子树的处理顺序都是，先左子树、再头节点、然后右子树
 * 后序：任何子树的处理顺序都是，先左子树、再右子树、然后头节点
 *
 * 递归函数可以保证每一个节点都回到自己三次
 * 通过递归方式先序，中序，后序打印节点
 *               1
 *            2      3
 *          4   5  6   7
 */
public class Code01_RecursiveTraversalBT {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int v){
            value = v;
        }
    }

    //先序方式打印节点
    public static void pre(Node head){
        if(head == null){
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    //中序方式打印节点
    public static void in(Node head){
        if(head == null){
            return;
        }

        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }

    //后序方式打印节点
    public static void pos(Node head){
        if(head == null){
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
