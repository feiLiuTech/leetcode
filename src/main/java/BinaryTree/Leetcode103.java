package BinaryTree;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 给定二叉树 [3,9,20,null,null,15,7],

     3
    / \
   9  20
  /    \
 15    7
 返回锯齿形层次遍历如下：

 [
 [3],
 [20,9],
 [15,7]
 ]

 */
public class Leetcode103 {
    /**
     * 层次遍历+双端对列
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder_1_20200831(BinaryTree.TreeNode root) {

        List<List<Integer>> res=new ArrayList();
        if(root==null){
            return res;
        }
        Deque<BinaryTree.TreeNode> dq=new LinkedList<BinaryTree.TreeNode>();
        dq.addLast(root);
        while(!dq.isEmpty()){
            int size=dq.size();
            LinkedList<Integer> list=new LinkedList<Integer>();
            for(int i=0;i<size;i++){
                BinaryTree.TreeNode node=dq.removeFirst();

                //奇数的时候从右向左放
                if(res.size()%2==1){
                    list.addFirst(node.val);
                }else{
                    list.addLast(node.val);
                }
                if(node.left!=null){
                    dq.addLast(node.left);
                }
                if(node.right!=null){
                    dq.addLast(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    /**
     * 层次遍历+奇偶判断
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder_2_20200831(BinaryTree.TreeNode root) {

        List<List<Integer>> res=new ArrayList();
        if(root==null){
            return res;
        }
        Deque<BinaryTree.TreeNode> dq=new LinkedList<BinaryTree.TreeNode>();
        dq.addLast(root);
        while(!dq.isEmpty()){
            int size=dq.size();
            List<Integer> temp=new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                BinaryTree.TreeNode node;
                if(res.size()%2!=0){
                    node=dq.removeLast();

                    if(node.right!=null){
                        dq.addFirst(node.right);
                    }
                    if(node.left!=null){
                        dq.addFirst(node.left);
                    }
                }else{
                    node=dq.removeFirst();

                    if(node.left!=null){
                        dq.addLast(node.left);
                    }
                    if(node.right!=null){
                        dq.addLast(node.right);
                    }
                }
                temp.add(node.val);

            }
            res.add(temp);
        }
        return res;
    }
}
