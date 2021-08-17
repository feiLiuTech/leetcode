package WrittenExamination;
import java.util.*;
public class Main {

    public void countPrimes(int l, int r) {
        if(l>r){
            System.out.println("ERROR");
            return ;
        }
        boolean[] prim = new boolean[r];
        for (int i = 2; i < r; i++) {
            prim[i] = true;
        }
        int count = 0;
        for (int i = 2; i * i < r; i++) {
            if (prim[i]) {
                for (int j = i * i; j < r; j += i) {

                    prim[j] = false;
                }
            }

        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = l; i < r; i++) {
            if (prim[i] == true) {
                res.add(i);
            }
        }
        if(res.size()==0){
            System.out.println("NO DATA");
            return;
        }
        for (int i = 0; i < res.size(); i++) {
            if (i != res.size() - 1) {
                System.out.print(res.get(i) + ",");
            } else {
                System.out.print(res.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        String [] arr=str.split(",");
        int l=Integer.valueOf(arr[0]);
        int r=Integer.valueOf(arr[1]);
        Main test=new Main();
        test.countPrimes(l,r);

    }


}
