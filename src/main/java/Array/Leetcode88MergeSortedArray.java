package Array;

/**
 * 合并两个有序的数组
 */
public class Leetcode88MergeSortedArray {
    public static void main(String[] args) {
        Leetcode88MergeSortedArray test=new Leetcode88MergeSortedArray();
        test.merge_20200831(new int[] {1,2,3,0,0,0}, 3, new int[]{2,5,6},3);
    }
    public void merge_20200831(int[] nums1, int m, int[] nums2, int n) {
        if(nums1==null || nums2==null){
            return ;
        }
        int i=m-1;
        int j=n-1;
        int index=m+n-1;
        while(i>=0&& j>=0){
            if(nums1[i]>nums2[j]){
                nums1[index--]=nums1[i];
                i--;
            }else{
                nums1[index--]=nums2[j];
                j--;
            }
        }
        while(i>=0){
            nums1[index--]=nums1[i--];
        }
        while(j>=0){
            nums1[index--]=nums2[j--];
        }
    }
}
