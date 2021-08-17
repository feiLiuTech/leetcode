package Array;

public class SwordOffer66ConstructArray {
    public int[] constructArr_20200922(int[] a) {
        if(a==null || a.length==0){
            return new int[0];
        }
        int [] ans=new int[a.length];
        ans[0]=1;
        ans[a.length-1]=1;
        int t=1;
        for(int i=1;i<a.length;i++){
            t*=a[i-1];
            ans[i]=t;
        }
        t=1;
        for(int i=a.length-2;i>=0;i--){
            t*=a[i+1];
            ans[i]*=t;
        }
        return ans;

    }
    public static void main(String[] args) {

    }
}
