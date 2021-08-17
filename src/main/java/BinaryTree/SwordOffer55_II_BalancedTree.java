package BinaryTree;

import java.util.TreeMap;

public class SwordOffer55_II_BalancedTree {
    public boolean flag=true;
    public boolean isBalanced_2020_0903(TreeNode root) {
        //左右子树的深度不超过1
        recur(root);
        return flag;

    }
    public int  recur(TreeNode root){
        if(root==null){
            return 0;
        }
        int depathL=recur(root.left);
        int depathR=recur(root.right);
        if(Math.abs(depathL-depathR)>1){
            flag=false;
        }
        return Math.max(depathL,depathR)+1;
    }




}
class SwordOffer55_II_BalancedTree_2020_0903 {
    public boolean isBalanced(TreeNode root) {
        //左右子树的深度不超过1
        int depathL=getDepth(root.left);
        int depathR=getDepth(root.right);
        return Math.abs(depathL-depathR)>1?false:isBalanced(root.left) &&isBalanced(root.right);
    }
    public int  getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int depathL=getDepth(root.left);
        int depathR=getDepth(root.right);
        return Math.max(depathL,depathR)+1;
    }


}

class SwordOffer55_II_BalancedTree_3_2020_0903 {

    public boolean isBalanced(TreeNode root) {
        //左右子树的深度不超过1

        return recur(root)!=-1;

    }
    public int  recur(TreeNode root){
        if(root==null){
            return 0;
        }
        //如果左子树不是平衡二叉树则返回-1，否则返回左子树的深度
        int depathL=recur(root.left);
        //剪枝
        if(depathL==-1){
            return -1;
        }
        int depathR=recur(root.right);
        //剪枝
        if(depathR==-1){
            return -1;
        }
        //如果右子树不是平衡二叉树则返回-1，否则返回右子树的深度
        return  Math.abs(depathR-depathL)>1?-1:Math.max(depathL,depathR)+1;
    }
}