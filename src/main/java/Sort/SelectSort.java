package Sort;

public class SelectSort {

    public static void main(String[] args) {
        SelectSort ss=new SelectSort();
        int [] nums=new int[]{3,1,2,9,5};
        ss.selectSort(nums);
        for(int i:nums){
            System.out.print(i+" ");
        }
    }
    public void selectSort(int [] nums){
        //无序数组中找出最小的和第一个进行交换
        for(int i=0;i<nums.length;i++){
            int min_index=i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[min_index]){
                    min_index=j;
                }
            }
            int temp=nums[i];
            nums[i]=nums[min_index];
            nums[min_index]=temp;
        }

    }
}
