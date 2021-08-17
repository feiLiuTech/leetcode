package WrittenExamination;
import java.util.*;
public class FindNumber {
    /**
     输入：
     135682318
     23457
     14282123
     14231728
     3
     1724153
     输出：
     135682318
     14231728
     * @param list
     * @param A
     * @param target
     */
    public void helper(List<String> list, int A, String target){
        String targetFeature=getFeature(target,A);
        for(int i=0;i<list.size()-2;i++){
            String s=list.get(i);
            String sFreature=getFeature(s,A);
            if(sFreature.indexOf(targetFeature)!=-1){
                System.out.println(s);
            }
        }
    }
    public String getFeature(String s, int A){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c-'0'<A){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FindNumber fn=new FindNumber();
        Scanner in=new Scanner(System.in);
        List<String> list=new ArrayList<String>();
        while(!in.hasNext("-1")){
            String s=in.nextLine();
            list.add(s);
        }

        int A=Integer.valueOf(list.get(list.size()-2));
        String target=list.get(list.size()-1);
        fn.helper(list, A, target);
    }
}
