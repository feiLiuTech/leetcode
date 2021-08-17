package BFS;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Leetcode210CourseScheduleII {
    public int[] findOrder_2020_0831(int numCourses, int[][] prerequisites) {
        //邻接表
        Set<Integer> [] adject_table=new Set[numCourses];
        //入度矩阵
        int [] inDegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adject_table[i]=new HashSet<Integer>();

        }
        for(int [] temp: prerequisites){
            int u=temp[0];
            int v=temp[1];
            //v->u
            adject_table[v].add(u);
            inDegree[u]+=1;
        }

        Deque<Integer>dq=new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                dq.addLast(i);
            }
        }
        int [] ans=new int[numCourses];
        int index=0;
        while(!dq.isEmpty()){
            int v=dq.poll();
            ans[index++]=v;
            for(int u: adject_table[v]){
                inDegree[u]-=1;
                if(inDegree[u]==0){
                    dq.addLast(u);
                }
            }
        }
        return numCourses==index?ans:new int[0];

    }
}
