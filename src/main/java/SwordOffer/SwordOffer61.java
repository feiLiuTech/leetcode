package SwordOffer;

import java.util.Arrays;

public class SwordOffer61 {

    public boolean isStraight(int[] nums) {
        if(nums==null || nums.length==0){
            return false;
        }
        Arrays.sort(nums);
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                continue;
            }
            int j=i;
            while(j<nums.length-1 && nums[j]+1==nums[j+1]){
                j++;
            }
            if(j!=nums.length-1){
                int diff=nums[j]-nums[i]-1;
                if(count>=diff){
                    count-=diff;
                }else{
                    return false;
                }
            }

        }
        return true;
    }
}
