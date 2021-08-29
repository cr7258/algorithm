package leetcode.linkedlist;

/**
 * @author chengzw
 * @description K个一组翻转链表，https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @since 2021/8/29
 */
public class ReverseKGroup {

    public static ListNode solution1(ListNode head, int k) {

        //虚拟节点
        ListNode dummyNode = new ListNode();
        ListNode tail = dummyNode;

        //p是原链表遍历指针
        ListNode p = head;
        while (p != null) {
            //计数，达到k个，反转链表
            int count = 0;
            //q遍历k个节点的链表
            ListNode q = p;
            while (q != null) {
                count++;
                if (count == k) {
                    break;
                }
                q = q.next;
            }

            //如果剩下的不到k个，是 q!=null 退出循环的
            //把剩下的添加到新链表后，不反转
            if (q == null) {
                tail.next = p;
                return dummyNode.next;
            } else {  //反转k个节点的链表
                //p传入reverseList以后回变化，先用tmp保存
                ListNode tmp = q.next;
                ListNode[] nodes = reverseList(p, q);
                tail.next = nodes[0];
                tail = nodes[1];
                p = tmp;
            }
        }
        return dummyNode.next;
    }


    //反转链表
    //传入k个节点的链表的头节点和尾节点
    //返回反转的链表头节点和尾节点
    public static ListNode[] reverseList(ListNode head, ListNode tail) {


        //p是k个长度的链表的遍历指针
        ListNode p = head;
        //头节点
        ListNode newHead = null;
        //反转链表
        while (p != tail) {
            ListNode tmp = p.next;
            p.next = newHead;
            newHead = p;
            p = tmp;
        }

        tail.next = newHead;
        return new ListNode[]{tail, head};
    }

    public static void main(String[] args) {
        ListNode result1 = solution1(ListNode.createNode(new int[]{1, 2, 3, 4, 5}), 2);
        System.out.println(ListNode.printNode(result1));
    }
}
