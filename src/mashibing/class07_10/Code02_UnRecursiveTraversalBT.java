package mashibing.class07_10;

import java.util.Stack;

/**
 * 非递归方式二叉树的先序、中序、后序遍历
 *               1
 *            2      3
 *          4   5  6   7
 */

public class Code02_UnRecursiveTraversalBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    /**
     * 非递归方式先序遍历：头左右
     * 1.从栈顶出来的记为cur
     * 2.有右压入右，有左压入左，先右再左
     */
    public static void pre(Node head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            //不由分说先把头结点压栈
            stack.push(head);
            while (!stack.isEmpty()) {
                //从栈顶出来的记为cur
                Node cur = stack.pop();
                System.out.print(cur.value + " ");
                //先右再左
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        System.out.println();
    }

    /**
     * 非递归方式中序遍历：左头右
     * 1.当前节点cur，cur为头的树，整条左边界进栈直到遇到null
     * 2.当第一步遇到null时，从栈中弹出节点打印，该节点的右孩子成为cur，然后回到第1步
     * 3.当栈为空了就停止
     */
    public static void in(Node cur) {
        System.out.print("in-order: ");
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.print(cur.value + " ");
                cur = cur.right;
            }
        }

        System.out.println();
    }

    /**
     * 非递归方式后序遍历：左右头
     * 1.准备两个栈
     * 2.第一个栈从栈顶出来记为cur，有右压入右，有左压入左，先左再右（和前面先序相反）,最后得到头右左，压入另一个栈
     * 3.另一个栈依次从栈顶弹出，得到左右头，就是后续遍历
     */
    public static void pos1(Node head) {
        System.out.print("pos-order: ");
        if (head != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                Node cur = stack1.pop();
                stack2.push(cur);
                if (cur.left != null) {
                    stack1.push(cur.left);
                }
                if (cur.right != null) {
                    stack1.push(cur.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().value + " ");
            }
        }

        System.out.println();
    }

    //用一个栈实现非递归后序遍历
    public static void pos2(Node h) {
        System.out.print("pos-order: ");
        if (h != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(h);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    h = c;
                }
            }
        }
        System.out.println();
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
        pos1(head);
        System.out.println("========");
        pos2(head);
        System.out.println("========");
    }

}
