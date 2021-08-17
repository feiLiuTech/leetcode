package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 注意:
 你可以假设树中没有重复的元素。
 例如，给出
 前序遍历 preorder = [3,9,20,15,7]
 中序遍历 inorder = [9,3,15,20,7]
 返回如下的二叉树：
 3
 / \
 9  20
 /  \
 15   7

 */

public class Leetcode105buildTree {

    private Map<Integer, Integer> mapInOrder=new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<preorder.length;i++){
            mapInOrder.put(inorder[i],i);
        }
        return recur(0,preorder.length-1,0, inorder.length-1, preorder);
    }

    public TreeNode recur(int preL, int preR, int inL, int inR, int [] preOrder){
        if(preL>preR || inL>inR){
            return null;
        }
        //根据前序序列获取根节点
        int val=preOrder[preL];
        TreeNode root=new TreeNode(val);
        //获取根节点在后序序列中的索引
        int index=mapInOrder.get(val);
        int lenL=index-inL;//左子树节点的个数

        //根据左右子树的长度确定前序遍历的左右边界
        root.left=recur(preL+1,preL+lenL, inL,index-1,preOrder );

        int lenR=inR-index;//右子树节点的个数
        root.right=recur(preL+lenL+1, preR, index+1, inR,preOrder);

        return root;
    }
}

