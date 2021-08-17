package WrittenExamination;
import java.util.*;
import java.util.regex.Pattern;

public class Main3 {
    public static boolean isNumeric(String str) {
        if(str.charAt(str.length()-1)=='.'){
            str=str.substring(0,str.length()-1);
        }
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        String [] str_num=str.split(" ");
        //1000-3000
        for(int i=0;i<str_num.length;i++){
            String s=str_num[i];

            if(isNumeric(s)){
                if(s.charAt(str.length()-1)=='.'){
                    s=s.substring(0,s.length()-1);
                }
                int val=Integer.valueOf(s);
                if(val>=1000 && val<=3000){
                    System.out.print(val+" ");
                }
            }
        }

    }


}
