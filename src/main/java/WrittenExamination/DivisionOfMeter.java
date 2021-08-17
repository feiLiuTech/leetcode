package WrittenExamination;
import java.util.*;
/**
 * 给一个n(4<=n<=200)，输出一个n*n的矩阵，要求在矩阵中画一个米字，
 * 处于米字边界线的格子置0，其余格子按逆时针顺序填充1~8的数字
 */
public class DivisionOfMeter {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int [][] matrix=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i+j<n-1 && j>=(n+1)/2){
                    matrix[i][j]=1;
                }else if(i<j && j<(n/2)){
                    matrix[i][j]=2;
                }else if(i>j && i<n/2){
                    matrix[i][j]=3;
                }else if(i+j<n-1 && i>=(n+1)/2){
                    matrix[i][j]=4;
                }else if(i+j>n-1 && j<n/2){
                    matrix[i][j]=5;
                }else if(i>j && j>=(n+1)/2){
                    matrix[i][j]=6;
                }else if(i<j && i>=(n+1)/2){
                    matrix[i][j]=7;
                }else if(i+j>n-1 && i<n/2){
                    matrix[i][j]=8;
                }else{
                    matrix[i][j]=0;
                }
                if(j!=n-1){
                    System.out.print(matrix[i][j]+" ");
                }else{
                    System.out.print(matrix[i][j]);
                }

            }
            System.out.println("\n");
        }
    }


}
