package WrittenExamination;
import java.util.*;
//135682318
//23457
//14282123
//14231728
//3
//1724153
//-1
public class FindFeature {
    public static String getFeature(String s, int A){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Integer.valueOf(c-'0')<A){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        List<String> list=new ArrayList<String>();
        while(!in.hasNext("-1")){
            list.add(in.nextLine());
        }
        int A=Integer.valueOf(list.get(list.size()-2));
        String target=list.get(list.size()-1);
        String target_feature=getFeature(target,A);
        for(int i=0;i<list.size()-2;i++){
            String feature=getFeature(list.get(i),A);
            //System.out.println(feature);
            if(feature.indexOf(target_feature)!=-1){
                System.out.println(list.get(i));
            }
        }

    }
}
