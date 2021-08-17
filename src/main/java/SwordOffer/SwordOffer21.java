package SwordOffer;

/**
 *输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 示例：
 输入：nums = [1,2,3,4]
 输出：[1,3,2,4]
 注：[3,1,2,4] 也是正确的答案之一。
 */
public class SwordOffer21 {
    /**
     * 首尾双指针
     * @param nums
     * @return
     */
    public int[] exchange_1_20200831(int[] nums) {
        if(nums==null || nums.length==0){
            return new int[0];
        }
        int i=0, j=nums.length-1;
        while(i<j){
            //i寻找偶数，j寻找奇数
            while(i<j && nums[i]%2!=0){
                i++;
            }
            while(i<j && nums[j]%2==0){
                j--;
            }
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        return nums;
    }

    public int[] exchange_2_20200831(int[] nums) {
        if(nums==null || nums.length==0){
            return new int[0];
        }
        int i=0, j=0;
        //偶数跳过，奇数交换
        for(;j<nums.length;j++){
            if(nums[j]%2!=0){
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                i++;
            }
        }
        return nums;
    }
}
