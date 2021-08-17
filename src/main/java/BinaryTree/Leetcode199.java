package BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 示例:
 输入: [1,2,3,null,5,null,4]
 输出: [1, 3, 4]
 解释:

       1            <---
     /   \
    2    3         <---
    \     \
    5     4       <---

 */
public class Leetcode199 {
    /**
     * 利用层次遍历记录下每层的最后一个元素
     * @param root
     * @return
     */
    public List<Integer> rightSideView_20200831(TreeNode root) {

        List<Integer> res=new ArrayList<Integer>();
        if(root==null){
            return res;
        }
        Deque<TreeNode> dq=new LinkedList<TreeNode>();
        dq.addLast(root);
        while(!dq.isEmpty()){
            int size=dq.size();
            for(int i=0;i<size;i++){
                TreeNode node=dq.removeFirst();
                if(i==size-1){
                    res.add(node.val);
                }
                if(node.left!=null){
                    dq.addLast(node.left);
                }
                if(node.right!=null){
                    dq.addLast(node.right);
                }
            }
        }
        return  res;
    }

    /**
     * 利用dfs,先根->右—>左
     * 关键点，判断当前深度是否出现在结果集中，如果没有说明是当前深度中第一次出现的节点，加入结果集，否则不是
     * @param root
     * @return
     */
    public List<Integer> rightSideView_2_20200831(TreeNode root) {

        List<Integer> res=new ArrayList<Integer>();
        if(root==null){
            return res;
        }
        dfs(root, 0, res);
        return  res;
    }
    public void dfs(TreeNode root, int depth, List<Integer> res){
        if(root==null){
            return ;
        }
        if(depth==res.size()){
            res.add(root.val);
        }
        dfs(root.right, depth+1, res);
        dfs(root.left, depth+1, res);
    }

}

