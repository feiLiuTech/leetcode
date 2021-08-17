package String.Leetcode459;

import java.util.ArrayList;

public class RepeatedSubStr {

    public boolean repeatedSubstringPattern(String s) {
        if(s==null || s.length()==0){
            return false;
        }
        for(int i=0;i<s.length();i++){
            String t=s;
            String str=s.substring(0,i+1);
            if(t.replace(str,"").length()==0){
                return true;
            }
        }
        return false;
    }
    public static void fun(String str, char [] chs){
        str="Never Settle";
        chs[0]='6';
    }
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        StringBuilder sb=new StringBuilder();
        for(int i=101;i<=200;i+=2){
            if(isPrime(i)){
                list.add(i);
                sb.append(i).append("\n");
            }
        }
        System.out.println(list.size());
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
    public static boolean isPrime(int n){
        for(int i=2;i<n/2+1;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
