package WrittenExamination;

import java.util.*;

public class Main6 {
    class Interval{
        int start;
        int end;
    }
   public Interval solve(int n, int k, String str1, String str2){
       Main6 test=new Main6();
       Main6.Interval ans=test.new Interval();

       if(str1.equalsIgnoreCase(str2)){
           //如果两个人的答案完全一致，那么第一个人也答对了k道题
           ans.start=k;
           ans.end=k;
           return ans;
       }else{
           //找出有多少个相同的答案
           int count=0;
           for(int i=0;i<n;i++){
               if(str1.charAt(i)==str2.charAt(i)){
                   count++;
               }
           }
           if(n==k){
               //如果第二个人全部答对了，那么只要知道第一个人和第二个人有多少相同的
               ans.start=count;
               ans.end=count;
               return ans;
           }else{
               //第二个朋友没有全部答对的话，只作对了k道
             if(count==0){
                       //如果一个答案都不一样，而第二个朋友已经对了k道题，那么最多对n-k
                       ans.start=0;
                       ans.end=n-k;
                   }else{
                       //相同的里面是否包含正确的答案
                       if(count+k==n){
                           ans.start=0;
                       }
                       ans.start=0;

                       ans.end=Math.max(count,n-count);
               }
           }

       }
       return ans;

   }
    public static void main(String[] args) {


    }

}


