package Sort;

public class QuickSort {
    /**
     * 填数挖坑法
     * 易错点1：在寻找比枢纽值小或者大的值的时候，要注意L<R
     * 易错点2：只有满足L<R，才进行填坑并指针移动
     *
     */
    public int[] sortArray_2020_0903(int[] nums) {
        if(nums==null || nums.length==0){
            return new int[0];
        }

        quickSort(0, nums.length-1, nums);
        return nums;
    }
    public void quickSort(int L, int R, int [] nums){
        if(L>=R){
            return;
        }
        int l=L;
        int r=R;
        int pivot=nums[L];
        while(l<r){
            while(l<r && nums[r]>pivot){
                r--;
            }
            if(l<r){
                nums[l]=nums[r];
                l++;
            }

            while(l<r && nums[l]<pivot){
                l++;
            }
            if(l<r){
                nums[r]=nums[l];
                r--;
            }

        }
        nums[l]=pivot;
        quickSort(L,l-1, nums);
        quickSort(l+1,R, nums);
    }


    /**
     * 易错点1：从左边开始找的一定要跳过第一个点，也就是num[l]<=pivot
       易错点2：找到了最终的位置之后需要交换枢纽值
     * @param L
     * @param R
     * @param nums
     */
    public void quickSort2(int L, int R, int [] nums){
        if(L>=R) {
            return;
        }
        int l=L,r=R;
        int pivot=nums[l];
        while(l<r){
            while(l<r && nums[r]>pivot){
                r--;
            }
            while(l<r && nums[l]<=pivot){
                l++;
            }
            if(l<r){
                swap(nums,l,r);

            }
        }
        //nums[L]=pivot;
        swap(nums,L,l);
        quickSort2(L,l-1, nums);
        quickSort2(l+1,R, nums);
    }
    public void swap(int [] nums, int start, int end){
        int temp=nums[start];
        nums[start]=nums[end];
        nums[end]=temp;
    }

}

class QuickSort2020_0909 {
    /**
     * 填数挖坑法
     * 易错点1：在寻找比枢纽值小或者大的值的时候，要注意L<R
     * 易错点2：只有满足L<R，才进行填坑并指针移动
     *
     */
    public int[] sortArray(int[] nums) {
        if(nums==null || nums.length==0){
            return new int[0];
        }

        quickSort(0, nums.length-1, nums);
        return nums;
    }
    public void quickSort(int L, int R, int [] nums){
        if(L>=R){
           return ;
        }
        int l=L, r=R;
        int pivot=nums[L];
        while(l<r){
            while(l<r && nums[r]>pivot){
                r--;
            }
            if(l<r){
                nums[l]=nums[r];
                l++;
            }

            while(l<r && nums[l]<pivot){
                l++;
            }
            if(l<r){
                nums[r]=nums[l];
                r--;
            }
        }
        nums[l]=pivot;
        quickSort(L,l-1,nums);
        quickSort(l+1,R,nums);
    }

}