package Math;

public class Leetcode204CountPrimes {
    /**
     * 统计所有小于非负整数 n 的质数的数量。
     示例:
     输入: 10
     输出: 4
     解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     *
     */
    public static void main(String[] args) {
        Leetcode204CountPrimes test=new Leetcode204CountPrimes();
        test.countPrimes(10);
    }
    public int countPrimes(int n) {
        boolean [] prim=new boolean[n];
        for(int i=2;i<n;i++){
            prim[i]=true;
        }
        int count=0;
        for(int i=2;i*i<n;i++){
            if(prim[i]){
                for(int j=i*i;j<n;j+=i){
                    /**
                     # 因为i是质数，所以我们需要把2*i, 3*i, 4*i等这些i的倍数给删除掉
                     # 比如i=2时，我们要删除4, 6, 8等
                     # 当i=3时，我们要删除6, 9, 12等，发现了吧，6重复了删除了，
                     # 所以不管i是什么，我们从i*i开始就可以避免重复，i=3时就从i*i=9开始删除
                     **/
                    prim[j]=false;
                }
            }

        }

        for(int i=2;i<n;i++){
            if(prim[i]==true){
                count++;
            }
        }
        return count;
    }
}
