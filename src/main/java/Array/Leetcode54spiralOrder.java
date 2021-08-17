package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵：
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 输入:
 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 输出: [1,2,3,6,9,8,7,4,5]
 */
public class Leetcode54spiralOrder {
    /**
     * 关键点是再进行上下左右消除行列的时候判断中不能加等号
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder_1_2020_0830(int[][] matrix) {

        List<Integer> ans=new ArrayList<Integer>();
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return ans;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int up=0,down=m-1,left=0,right=n-1;
        while(true){
            //向右

            for(int i=left;i<=right;i++){
                ans.add(matrix[up][i]);
            }
            if(++up>down){
                break;
            }
            //向下
            for(int i=up;i<=down;i++){
                ans.add(matrix[i][right]);
            }
            if(--right<left){
                break;
            }

            //向左
            for(int i=right;i>=left;i--){
                ans.add(matrix[down][i]);
            }
            if(--down<up){
                break;
            }
            //向上
            for(int i=down;i>=up;i--){
                ans.add(matrix[i][left]);
            }
            if(++left>right){
                break;
            }

        }

        return ans;
    }

    /**
     * 或者
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder_2_2020_0830(int[][] matrix) {

        List<Integer> ans=new ArrayList<Integer>();
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return ans;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int u=0,d=m-1;
        int l=0,r=n-1;
        int i=1;
        while(i<=n*m){
            for(int j=l;j<=r && i<=n*m;j++){
                ans.add(matrix[u][j]);
                i++;
            }
            u++;
            for(int j=u;j<=d && i<=n*m;j++){
                ans.add(matrix[j][r]);
                i++;
            }
            r--;
            for(int j=r;j>=l && i<=n*m;j--){
                ans.add(matrix[d][j]);
                i++;
            }
            d--;
            for(int j=d;j>=u && i<=n*m;j--){
                ans.add(matrix[j][l]);
                i++;
            }
            l++;
        }

        return ans;
    }
}
