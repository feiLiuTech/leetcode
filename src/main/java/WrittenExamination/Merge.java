package WrittenExamination;

import java.util.*;

public class Merge {
    public static void main(String[] args) {
        int [] nums=new int[]{1,3,5,2};

        Map<Integer,Integer> map=new HashMap<Integer, Integer>();

        for(int i=0;i<4;i++){
            map.put(i,nums[i]);
        }
        int count=0;
        int min=Integer.MAX_VALUE;
        int s=0,e=0;
        int a=0,b=0;
        while(map.size()!=1){
            for(int i=0;i<map.size()-1;i++){

                a=map.get(i);
                b=map.get(i+1);

                if(a+b<min){
                    min=a+b;
                    s=i;
                    e=i+1;
                }

            }
            count+=min;
            map.remove(s);
            map.remove(e);
            map.put(s,min);
            int x=e+1;
            for(;x<4;x++){
                int val=map.get(x);
                map.remove(x);
                map.put(x-1,val);
            }

        }
        System.out.println(count);


    }
}
