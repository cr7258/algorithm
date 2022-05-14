package leetcode.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chengzw
 * @description 非递归方式 二叉树的后序遍历，https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * @since 2021/9/21
 */
public class PostorderTraversalNoRecursive {
    private List<Integer> result = new ArrayList<>();
    public class SFrame{
        public int status = 1;
        public TreeNode node = null;
        public SFrame(int status,TreeNode node){
            this.status = status;
            this.node = node;
        }
    }

    public List<Integer> postorderTraversalNoRecursive(TreeNode root){
        if(root == null) return result;
        Stack<SFrame> stack = new Stack<>();
        stack.push(new SFrame(1,root));
        while (!stack.isEmpty()){
            if(stack.peek().status == 1){
                stack.peek().status = 2;
                if(stack.peek().node.left != null){
                    stack.push(new SFrame(1,stack.peek().node.left));
                }
            }else if(stack.peek().status == 2){
                stack.peek().status = 3;
                if(stack.peek().node.right != null){
                    stack.push(new SFrame(1,stack.peek().node.right));
                }
            }else {
                //后序遍历
                result.add(stack.pop().node.val);
            }
        }
        return result;
    }
}
