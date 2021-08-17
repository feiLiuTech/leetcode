package WrittenExamination;
import java.util.*;


public class Main7 {
    String str="hello";
    char [] ch={'a','b','c'};
    public static  int twoCitySchedCost(int[][] costs) {
        int t = costs.length;
        int diff[] = new int[t];
        int sum = 0;
        for(int i=0;i<t;i++){
            diff[i] = costs[i][1]-costs[i][0];//计算到A城与到B城的消耗差
            sum +=costs[i][0];//加上所有人到A城的费用
        }
        Arrays.sort(diff);
        for(int i=t/2;i<t;i++)
            sum+=diff[i];//减去应到B城的人员的额外消耗
        return sum;
    }

    public static void main(String[] args) {

//        Scanner in=new Scanner(System.in);
////        List<Integer> list=new ArrayList<Integer>();
////        while(!in.hasNext("#")){
////            list.add(in.nextInt());
////        }
////        int n=list.size()/2;
////        int [][] costs=new int[n][2];
////        for(int i=0;i<n;i++){
////            costs[i][0]=list.get(i*2);
////            costs[i][1]=list.get(i*2+1);
////        }
////        int ans=twoCitySchedCost(cosqts);
////        System.out.println(ans);
          int [] a=new int[2];
          Object [] b=new Object[2];
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

}
