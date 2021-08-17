package WrittenExamination;
import java.util.*;
//[-5,0,6,8,9,10],[0,8,9,11,15]
public class CommonPart {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        String [] arr=str.split("],");
        String s1=arr[0];
        StringBuilder sb=new StringBuilder(s1);
        String [] s1_arr=sb.deleteCharAt(0).toString().split(",");
        int [] nums1=process(s1_arr);
        String s2=arr[1];
        sb.deleteCharAt(0).deleteCharAt(s2.length()-1);
        String [] s2_arr=sb.toString().split(",");
        int [] nums2=process(s2_arr);


    }
    public static int [] process(String [] str){
        int [] nums=new int[str.length];
        for(int i=0;i<str.length;i++){
            nums[i]=Integer.valueOf(str[i]);
        }
        return nums;
    }
}
