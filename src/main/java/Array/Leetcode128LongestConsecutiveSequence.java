package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode128LongestConsecutiveSequence {
    public static void main(String[] args) {
        Leetcode128LongestConsecutiveSequence test=new Leetcode128LongestConsecutiveSequence();
        test.longestConsecutive_1_2020_0830(new int[]{100,4,200,1,3,2});
    }

    /**
     * hashSet法
     * 关键点：对于任意一个元素，如果它还有前驱，那么从前驱算连续长度一定比从自身开始要长
     * 例如8,7,1,2 其中8还有前驱7,应该从7计算长度，故8可以直接跳过
     *
     * @param nums
     * @return
     */
    public int longestConsecutive_1_2020_0830(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        Set<Integer> set=new HashSet();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int max_len=0;
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]-1)){
               continue;
            }
            int val=nums[i];
            while(set.contains(val+1)){
                val+=1;
            }
            max_len=Math.max(max_len,val-nums[i]+1);

        }
        return max_len;
    }

    public int longestConsecutive_2_2020_0830(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],nums[i]);
        }
        int max_len=1;
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            int r=val;
            while(map.containsKey(r+1)){
                r=map.get(r+1);
            }
            map.put(val,r);
            max_len=Math.max(max_len,r-val+1);

        }
        return max_len;
    }
}
