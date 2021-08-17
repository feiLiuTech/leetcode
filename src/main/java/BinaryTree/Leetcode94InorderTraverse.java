package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode94InorderTraverse {
    public List<Integer> res=new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {

        if(root==null){
            return res;
        }
        recur(root);
        return res;
    }

    /**
     * 递归法
     * @param root
     */
    public void recur(TreeNode root){
        if(root==null){
            return ;
        }
        recur(root.left);
        res.add(root.val);
        recur(root.right);
    }

    /**
     * 非递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal20200911(TreeNode root) {


        if(root==null){
            return res;
        }
        Stack<TreeNode> stack=new Stack();
        TreeNode cur=root;

        while(!stack.isEmpty() || cur!=null ){
            while(cur!=null){
                stack.add(cur);
                cur=cur.left;

            }
            TreeNode node=stack.pop();
            res.add(node.val);
            cur=node.right;
        }
        return res;
    }
}


class Leetcode94InorderTraverse_2020_0913{

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode cur=root;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode node=stack.pop();
            res.add(node.val);
            cur=node.right;

        }
        return res;

    }
}