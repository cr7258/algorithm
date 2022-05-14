package learning.class06_02;

/**
 * 给定两个可能有环也可能无环的单链表，头节点head1和head2。请实现一个函数，如果两个链表相交，请返回相交的 第一个节点。如果不相交，返回null
 * 【要求】
 * 如果两个链表长度之和为N，时间复杂度请达到O(N)，额外空间复杂度 请达到O(1)。
 */

public class Code05_FindFirstIntersectNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        //一个有环，另一个无环的情况不满足题目的要求
        return null;

    }


    // 找到链表第一个入环节点，如果无环，返回null
    // 1.快慢指针，n1走一步，n2走两步
    // 2.当n1和n2相遇时，n2返回起点
    // 3.然后n1,n2 每一次走一步
    // 4.再次相遇时，返回n1，就是第一个入环节点
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }


    //如果两个链表都无环，返回第一个相交节点，如果不相交，返回null
    //情况一：长链表先走差值步，然后一起走，相遇的点就是第一个相交点，到null是最后一个相交点
    public static Node noLoop(Node head1, Node head2) {
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }

        //如果最后一个节点不相等，说明没有相交
        if (cur1 != cur2) {
            return null;
        }

        cur1 = n > 0 ? head1 : head2; //长链表
        cur2 = cur1 == head1 ? head2 : head1;  //短链表

        //n为长短链表的差值
        n = Math.abs(n);

        //长链表先走差值步
        while (n > 0) {
            cur1 = cur1.next;
            n--;
        }
        //然后两个链表一起走
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;


    }

    //两个有环链表，返回第一个相交节点，如果不相交返回null
    //情况二：如果入环点是相同的，看做是情况一的变种，入环位置就是最后一个相交点
    //情况三：如果有两个入环点，从loop1从发绕一圈必定能遇到loop2
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1.next != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2.next != loop2) {
                n--;
                cur2 = cur2.next;
            }

            cur1 = n > 0 ? head1 : head2; //长链表
            cur2 = cur1 == head1 ? head2 : head1;  //短链表

            //n为长短链表的差值
            n = Math.abs(n);

            //长链表先走差值步
            while (n > 0) {
                cur1 = cur1.next;
                n--;
            }
            //然后两个链表一起走
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;

            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }


    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        // 情况一：两个都无环，相交后是直线
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        //情况二：两个都有环，有一个交点
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        //情况三：两个都有环，有两个交点
        System.out.println(getIntersectNode(head1, head2).value);

    }
}
