package WrittenExamination;

import java.util.*;

public class Main4 {
    public static double squar(double x, int n){
        double res=0;
        long b=n;
        while(b>0){
            if(b%2==1){
                res=res*x;
            }
            x=x*x;
            b=b/2;
        }
        return res;
    }
    public static void helper(String [] strs, String pattern){
        int [] pattern_num=new int[pattern.length()];
        String pattern_target=get_pattern(pattern);
        for(int i=0;i<strs.length;i++){
            String t=strs[i];
            String t_pattern=get_pattern(t);
            if(pattern_target.equals(t_pattern)){
                System.out.println(t);
            }
        }
    }
    public static String get_pattern(String str){
        Set<Character> set=new HashSet<Character>();
        List<Character>list=new ArrayList<Character>();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(!set.contains(c)){
                set.add(c);
                list.add(c);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<str.length();j++){
            char c=str.charAt(j);

            for(int y=0;y<list.size();y++){
                if(c==list.get(y)){
                    sb.append(y);
                }
            }
        }
        return sb.toString();

    }


    public static void main(String[] args) {
        String [] arr=new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"
        };
        String pattern="aba";
        helper(arr, pattern);

    }
}
