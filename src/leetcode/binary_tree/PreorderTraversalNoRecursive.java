package leetcode.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chengzw
 * @description 非递归方式 二叉树的前序遍历，https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @since 2021/9/21
 */

/**
 * 思路：
 * 1.利用栈模拟函数栈
 * 2.栈中的元素是一个 SFrame 类型
 *  status 有 3 个值：
 *  2.1 第一次压入栈是置为 1，当遇到栈顶元素的 status 为 1 时，遍历它左子树，然后修改 status 为 2
 *  当遇到栈顶元素的 status 为 2 时，遍历它的右子树，然后修改 status 为 3
 *  当遇到栈顶元素的 status 为 3 时，出栈
 *  2.2 node 是 TreeNode 类型
 * 3.有一个名为 result 的 ArrayList 来收集结果，前序遍历在元素 status 为 1 时就添加
 *
 */
public class PreorderTraversalNoRecursive {
    //存放结果
    List<Integer> result = new ArrayList<>();
    //SFrame 结构
    public class SFrame{
        public int status = 1;
        public TreeNode node = null;
        public SFrame(int status,TreeNode node){
            this.status = status;
            this.node = node;
        }
    }

    public List<Integer> preorderTraversalNoRecursive(TreeNode root){
        //使用栈来模拟函数栈
        Stack<SFrame> stack = new Stack<>();
        //特殊情况
        if(root == null) return result;
        //先把二叉树顶元素入栈
        stack.push(new SFrame(1,root));
        //模拟递归
        while (!stack.isEmpty()){
            //当遇到栈顶元素的 status 为 1 时，遍历它左子树，然后修改 status 为 2
            if(stack.peek().status == 1){
                //前序遍历在元素 status 为 1 时就将元素添加到结果中
                result.add(stack.peek().node.val);
                //修改 status 值 为 2
                stack.peek().status = 2;
                //将左子树元素入栈
                if(stack.peek().node.left != null){
                    stack.push(new SFrame(1,stack.peek().node.left));
                }
                //当遇到栈顶元素的 status 为 2 时，遍历它的右子树，然后修改 status 为 3
            }else if(stack.peek().status == 2){
                stack.peek().status = 3;
                //将右子树元素入栈
                if(stack.peek().node.right != null){
                    stack.push(new SFrame(1,stack.peek().node.right));
                }
                //当遇到栈顶元素的 status 为 3 时，出栈
            }else {
                stack.pop();
            }
        }
        return result;
    }
}
