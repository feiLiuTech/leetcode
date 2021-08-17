package WrittenExamination;
import java.util.*;

public class Main8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int x = in.nextInt();
        int ans = 0;
        int diff = 0;
        for (int i = 0; i < m; i++) {
            x=250;

            if (100 * c >= x) {
                int num = x / 100;
                if (x % 100 == 0) {
                    //如果能整除
                    diff = 0;
                    //投币次数加num
                    ans += num;
                    //100的少num张
                    c -= num;
                    x = 0;
                } else {
                    //找零
                    diff = (num + 1) * 100 - x;
                    ans += (num + 1);
                    //100的少num张
                    c -= (num + 1);
                    x=0;
                }

                if (diff > 0) {
                    b += diff / 50;
                    diff-=(diff/50)*50;
                    a += diff / 10;
                }

            }else{
                x=x-c*100;
                ans+=c;
            }
            if(x>0){
                if (50 * b >= x) {
                    int num = x / 50;
                    if (x % 50 == 0) {
                        //如果能整除
                        diff = 0;
                        //投币次数加num
                        ans += num;
                        //100的少num张
                        a -= num;
                        x = 0;
                    } else {
                        //找零
                        diff = (num + 1) * 50 - x;
                        ans += (num + 1);
                        //100的少num张
                        a -= (num + 1);
                        x -= 50 * (num + 1);
                    }

                    if (diff > 0) {
                        a += diff / 10;
                    }
                }
                ans += x / 10;

            }
        }

        System.out.println(ans);
    }
}
//2
//1
//4
//3
//250