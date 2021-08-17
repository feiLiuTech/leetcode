package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode144preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        Stack<TreeNode> s=new Stack<TreeNode>();
        if(root==null){
            return res;
        }
        TreeNode cur=root;
        while(cur!=null || !s.isEmpty()){
            while(cur!=null){
                res.add(cur.val);
                cur=cur.left;
            }
            TreeNode node=s.pop();
            cur=node.right;
        }
        return res;

    }
}
