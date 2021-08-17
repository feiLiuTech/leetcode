package Math;

public class Leetcode50 {

    public static void main(String[] args) {
        myPow(2,-2);
    }

    public static double myPow(double x, int n) {

        if(n<0){
            x=1/x;
            n=-n;
        }
        double res=1;
        while(n>1){
            if(n%2==1){
                res=res*x;
            }
            x=x*x;
            n=n/2;
        }
        return res;
    }
}
