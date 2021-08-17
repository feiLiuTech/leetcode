package Sort;

/**
 * 泛型类
 * @param <T>
 */
public class BubbleSort<T extends Comparable<T>> {
    public static void main(String[] args) {
        BubbleSort bs=new BubbleSort();
        Integer [] numsInt=new Integer[]{4,1,3,2,5};
        bs.bubbleSort(numsInt);
        for(Integer i: numsInt){
            System.out.print(i+" ");
        }
        System.out.print("\n");
        Double [] numsDouble=new Double[]{4.1,1.4,3.2,2.0,5.3};
        bs.bubbleSort(numsDouble);
        for(Double i: numsDouble){
            System.out.print(i+" ");
        }
    }

    public  T[] bubbleSort(T [] nums){
        boolean flag=false;
        for(int i=nums.length-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(nums[j].compareTo(nums[j+1])>0){
                    T temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                    flag=true;
                }
            }
            if(!flag){
                break;
            }
        }
        return nums;
    }

}



