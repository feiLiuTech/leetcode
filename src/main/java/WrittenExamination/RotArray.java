package WrittenExamination;
import java.util.*;
public class RotArray {


    public  void rotArray(int [] nums){
        int [][] matrix=new int[4][4];
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    matrix[i][j]=nums[i*4+j];
                }
            }
            rotation(matrix);


        }

    public void rotation(int [][] matrix){

        int [][] ans=new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                ans[4-j-1][i]=matrix[i][j];
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println("\n");
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int [] nums=new int[16];
        for(int i=0;i<16;i++){
            nums[i]=in.nextInt();
        }

        RotArray test=new RotArray();
        test.rotArray(nums);
    }
}
