package BinaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Leetcode145postorderTraversal {

    public List<Integer> postorderTraversal_2020_0913(TreeNode root) {
        /**
         * 后序遍历 左->右->根
         * 后序逆序：根->右->左
         */
        List<Integer> res=new ArrayList<Integer>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode cur=root;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                res.add(cur.val);
                cur=cur.right;
            }

            TreeNode node=stack.pop();
            cur=cur.left;
        }
        Collections.reverse(res);
        return res;
    }

}
 class Leetcode145postorderTraversal_2020_0914{

    public List<Integer> postorderTraversal_1(TreeNode root) {
        /**
         * 后序遍历 左->右->根
         * 后序逆序：根->右->左
         * 使用双端队列进行存储逆序后的序列
         */

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        if (root == null) {
            return new ArrayList<Integer>();
        }
        LinkedList<Integer> temp = new LinkedList<Integer>();
        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                temp.addFirst(cur.val);
                s.push(cur);
                cur = cur.right;
            }
            TreeNode node = s.pop();
            cur = node.left;
        }
        return new ArrayList<Integer>(temp);
    }

     public List<Integer> postorderTraversal_2(TreeNode root) {
         /**
          * 后序遍历 左->右->根
          * 后序逆序：根->右->左
          * 使用双端队列进行存储逆序后的序列
          */
         List<Integer>res=new ArrayList<Integer>();
         Stack<TreeNode> s = new Stack<TreeNode>();
         TreeNode cur = root;
         if (root == null) {
             return new ArrayList<Integer>();
         }
         TreeNode last=cur;
         while (cur != null || !s.isEmpty()) {
             while (cur != null) {

                 s.push(cur);
                 cur = cur.left;
             }
             cur = s.peek();
             //这里可能cur.right==null 或者cur.right在前面访问过了，那么cur节点就可以输出了
             if(cur.right==null || cur.right==last){
                 res.add(cur.val);
                 cur=s.pop();
                 last=cur;
                 cur=null;
             }else{
                 cur=cur.right;
             }

         }
         return res;
     }
}