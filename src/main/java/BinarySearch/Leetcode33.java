package BinarySearch;

/**
 * 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

 你可以假设数组中不存在重复的元素。

 你的算法时间复杂度必须是 O(log n) 级别。

 示例 1:

 输入: nums = [4,5,6,7,0,1,2], target = 0
 输出: 4

 */
public class Leetcode33 {
    public int search_20200831(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return -1;
        }
        int L=0,R=nums.length-1;
        while(L+1<R){
            int mid=(R-L)/2+L;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<nums[R]){
                if(target<=nums[R] && target>nums[mid]){
                    L=mid+1;
                }else{
                    R=mid;
                }
            }else{
                if(target>=nums[L] && target<nums[mid]){
                    R=mid-1;
                }else{
                    L=mid+1;
                }
            }
        }
        //还剩两个
        if(target==nums[L]){
            return L;
        }
        if(target==nums[R]){
            return R;
        }
        return -1;

    }
}
