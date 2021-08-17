package DataStructure;

import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k个最大的元素，而不是第 k 个不同的元素。
 */
public class Leetcode215 {
    /**
     * 小根堆
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest_2020_0830(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        if(nums==null|| nums.length==0){
            return -1;
        }
        for(int i=0;i<nums.length;i++){
            if(pq.size()<k){
                pq.add(nums[i]);
            }else{
                if(pq.peek()<nums[i]){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();
    }
}
