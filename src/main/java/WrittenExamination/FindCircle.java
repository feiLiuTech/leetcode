package WrittenExamination;

import java.util.*;

public class FindCircle {
    public List<List<Integer>> res=new ArrayList();
    boolean [][] visited;
    Set<Integer>set=new HashSet<Integer>();
    public int start;
    public void helper(int [][] nums,int start){
        List<Integer> path=new ArrayList<Integer>();
        path.add(start);
        this.start=start;
        visited=new boolean[nums.length][nums.length];
        set.add(start);
        dfs(nums,start, 0, path);
        for(int i=0;i<res.size();i++){
            for(int j=0;j<res.get(i).size();j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.print("\n");
        }
    }
    public void dfs(int [][] nums, int row, int col, List<Integer> path){
        if(col==start && nums[row][col]==1 ){
            path.add(start);
            res.add(new ArrayList<Integer>(path));
            return ;
        }
        if(set.contains(row) && row!=start){
            return;
        }
        for(int i=col;i<nums.length;i++){
            if(nums[row][i]==1 && !visited[row][i]){
                visited[row][i]=true;
                path.add(i);
                set.add(i);
                dfs(nums, i, 0, path);
                visited[row][i]=false;
                path.remove(path.size()-1);
                set.remove(i);
            }
        }
    }
    public static void main(String[] args) {
        FindCircle f=new FindCircle();
        f.helper(new int[][]{{0,1,0,0,0},{0,0,1,1,0},{1,0,0,0,0},{0,0,0,0,1},{0,1,1,0,0}}, 4);
    }
}
