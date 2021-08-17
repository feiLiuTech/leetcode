package TwoPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

 注意：答案中不可以包含重复的三元组。
 示例：
 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class Leetcode15TreeSum {
    List<List<Integer>> res=new ArrayList<List<Integer>>();
    public List<List<Integer>> threeSum_20200831(int[] nums) {
        if(nums==null || nums.length==0){
            return res;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if((i>0 && nums[i]==nums[i-1]) || nums[i]>0){
                continue;
            }

            int target=nums[i];
            TwoSum(target, i+1, nums.length-1, nums);
        }
        return res;

    }
    public void TwoSum(int target, int L, int R, int [] nums){
        while(L<R){
            int sum=target+nums[L]+nums[R];
            if(sum==0){
                res.add(Arrays.asList(target,nums[L],nums[R]));
                L++;
                R--;
                while(L< R&& nums[L]==nums[L-1]){
                    L++;
                }
                while(L<R && nums[R]==nums[R+1]){
                    R--;
                }

            }else if(sum>0){
                R--;
            }else{
                L++;
            }
        }
    }
}
