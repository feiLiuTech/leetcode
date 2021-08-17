package WrittenExamination;

import LinkedList.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Password {
    private  List<List<Integer>> res=new ArrayList<List<Integer>>();
    long getPasswordCount(String password){

        for(int i=0;i<=9;i++){
            List<Integer> path=new ArrayList<Integer>();
            path.add(i);
            dfs(path,1,password);
        }
        System.out.println(res.size());
        for(int i=0;i<res.size();i++){
            for(int j=0;j<res.get(i).size();j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.print("\n");
        }
        return res.size();
    }
    public void dfs( List<Integer> path, int index, String password){
        if(index==password.length()){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        int val=Integer.valueOf(password.charAt(index)-'0');
        int sum=path.get(path.size()-1)+val;
        if(sum%2!=0){
            int up=sum/2+1;
            path.add(up);
            dfs(path, index+1, password);
            path.remove(path.size()-1);
        }
        path.add(sum/2);
        dfs(path, index+1, password);
        path.remove(path.size()-1);

    }
    public static void main(String[] args) {
        Password p=new Password();
        p.getPasswordCount("3");
    }
}
