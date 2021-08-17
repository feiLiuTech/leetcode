package Sort;

/**
 * 易错点1：在进行merge的时候temp的下标一定是从L->R
 * 易错点2: temp的index下标是L，不是0
 */
public class MergerSort{
    public int[] sortArray(int[] nums) {
        if(nums==null || nums.length==0){
            return new int[0];
        }
        int [] temp=new int[nums.length];
        mergeSort(0,nums.length-1,nums, temp);
        return  nums;
    }
    public void mergeSort(int L,int R, int [] nums, int [] temp){
        if(L>=R){
            return ;
        }
        int mid=(R-L)/2+L;
        mergeSort(L, mid, nums, temp);
        mergeSort(mid+1, R, nums, temp);
        merge(L,R, nums, temp);

    }
    public void merge(int L, int R, int [] nums, int[] temp){
        int mid=(R-L)/2+L;
        int l=L, r=mid+1;
        int index=L;
        while(l<=mid && r<=R){
            if(nums[l]<nums[r]){
                temp[index++]=nums[l++];
            }else{
                temp[index++]=nums[r++];
            }
        }
        while(l<=mid){
            temp[index++]=nums[l++];
        }
        while(r<=R){
            temp[index++]=nums[r++];
        }
        for(int i=L;i<=R;i++){
            nums[i]=temp[i];
        }
    }

}


 class MergerSort_20200908{
    public int[] sortArray(int[] nums) {
        if(nums==null || nums.length==0){
            return new int[0];
        }
        int [] temp=new int[nums.length];
        MergeSort(0,nums.length-1,nums,temp);
        return nums;
    }
    public void MergeSort(int L, int R, int[] nums, int [] temp){
        if(L>=R){
            return ;
        }
        int mid=(R-L)/2+L;
        MergeSort(L,mid,nums,temp);
        MergeSort(mid+1,R,nums,temp);
        merge(L,R,nums,temp);
    }
    public void merge(int L, int R, int [] nums, int [] temp){
        int mid=(R-L)/2+L;
        int l=L,r=mid+1;
        int index=L;
        while(l<=mid && r<=R){
            if(nums[l]<nums[r]){
                temp[index++]=nums[l++];
            }else{
                temp[index++]=nums[r++];
            }
        }
        while(l<=mid){
            temp[index++]=nums[l++];
        }

        while(r<=R){
            temp[index++]=nums[r++];
        }

        for(int i=L;i<=R;i++){
            nums[i]=temp[i];
        }

    }

}

class MergerSort_20200909{
    public int[] sortArray(int[] nums) {
        if(nums==null || nums.length==0){
            return new int[0];
        }
        int [] temp=new int[nums.length];
        MergeSort(0,nums.length-1,nums,temp);
        return nums;

    }
    public void MergeSort(int L, int R, int [] nums, int [] temp){
        if(L>=R){
            return ;
        }
        int mid=(R-L)/2+L;
        MergeSort(L,mid, nums, temp);
        MergeSort(mid+1,R, nums, temp);
        merge(L,R, nums, temp);

    }
    public void merge(int L,int R, int [] nums, int [] temp){
        int mid=(R-L)/2+L;
        int l=L, r=mid+1;
        int index=L;
        while(l<=mid && r<=R){
            if(nums[l]<nums[r]){
                temp[index++]=nums[l++];
            }else{
                temp[index++]=nums[r++];
            }
        }
        while(l<=mid){
            temp[index++]=nums[l++];
        }
        while(r<=R){
            temp[index++]=nums[r++];
        }
        for(int i=L;i<=R;i++){
            nums[i]=temp[i];
        }

    }


}