package WrittenExamination;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static  String binaryAll(int data) {

        StringBuffer buffer=new StringBuffer();
        String binary_h="0";
        String binary_o= Integer.toBinaryString(data);
        if(binary_o.toCharArray().length<8) {
            binary_h=new String(new char[8-binary_o.length()]).replace("\0", binary_h);//重复binsry_h
            buffer.append(binary_h+binary_o);
            return buffer.toString();
        }else {

            buffer.append(binary_o);
            return buffer.toString();
        }
    }

    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("-?[0-9]+(.[0-9]+)?");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        String s=in.nextLine();

        if(s.equals("-1")){
            System.out.println("1111111111111111,FFFF");
            return ;
        }
        if(!isNumeric(s) ){
            System.out.println("INPUTERROR");
            return ;
        }
        int num=Integer.valueOf(s);
        String s1=binaryAll(num);


        String s2=String.format("%04X",Integer.valueOf(s));

        System.out.println(s1+","+s2);
    }



}
