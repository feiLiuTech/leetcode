package BinarySearch;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 你的算法时间复杂度必须是 O(log n) 级别。
 如果数组中不存在目标值，返回 [-1, -1]。
 示例 1:
 输入: nums = [5,7,7,8,8,10], target = 8
 输出: [3,4]

 */
public class Leetcode34 {
    public int[] searchRange_2020_0901(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return new int []{-1,-1};
        }
        int [] ans=new int[2];
        ans[0]=findFirst(nums, target);
        ans[1]=findLast(nums,target);
        return  ans;
    }
    public int findFirst(int [] nums, int target){
        int L=0,R=nums.length-1;

        while(L+1<R){
            int mid=(R-L)/2+L;
            if(nums[mid]==target){
                //可能左边也有
                R=mid;
            }else if(nums[mid]<target){
                L=mid+1;
            }else{
                R=mid-1;
            }
        }
        //剩余俩个数
        if(nums[L]==target){
            return L;
        }
        if(nums[R]==target) {
            return R;
        }
        return -1;
    }
    public int findLast(int [] nums, int target){
        int L=0,R=nums.length-1;
        while(L+1<R){
            int mid=(R-L)/2+L;
            if(nums[mid]==target){
                //可能右边还有
                L=mid;
            }else if(nums[mid]>target){
                R=mid-1;
            }else{
                L=mid+1;
            }
        }
        if(nums[R]==target){
            return R;
        }else if(nums[L]==target){
            return L;
        }
        return -1;
    }

}
