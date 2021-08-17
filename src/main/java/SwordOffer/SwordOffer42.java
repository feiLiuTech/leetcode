package SwordOffer;

/**
 * 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 要求时间复杂度为O(n)。
 示例1:
 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 输出: 6
 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。


 */
public class SwordOffer42 {
    public int maxSubArray_2020_0831(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int n=nums.length;
        int [] dp=new int[n];//dp[i]表示以i为结尾的最大连续子数组和
        dp[0]=nums[0];
        int max_val=nums[0];
        int start=0,end=0;
        for(int i=1;i<n;i++){
            dp[i]=dp[i-1]>0?dp[i-1]+nums[i]:nums[i];
            if(dp[i]>max_val){
                max_val=dp[i];
                if(dp[i]==nums[i]){
                    //说明取的是自己
                    start=i;
                    end=i;
                }else{
                    end=i;
                }
            }

        }

        System.out.print(""+start+"->"+end);
        return max_val;
    }
}
