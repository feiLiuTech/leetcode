package BFS;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Leetcode207CourseSchedule {
    public boolean canFinish_2020_0831(int numCourses, int[][] prerequisites) {
        //1.建立邻接表
        Set<Integer>[] adject_table=new HashSet[numCourses];
        //2.建立入度数组
        int [] inDegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adject_table[i]=new HashSet<Integer>();
            inDegree[i]=0;
        }
        //初始化邻接表和入度数组
        for(int [] arr: prerequisites){
            int u=arr[0];
            int v=arr[1];
            //v->u
            adject_table[v].add(u);
            inDegree[u]+=1;
        }

        //建立队列,开始bfs
        Deque<Integer> dq=new LinkedList<Integer>();
        //将度为0的节点加入到队列中
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                dq.addLast(i);
            }
        }
        int count=0;
        while(!dq.isEmpty()){
            //将入度为0的节点从队列里删除
            int v=dq.poll();
            //以该节点的邻接节点的入度减去1
            //遍历邻接节点
            count++;
            for(int u: adject_table[v]){
                inDegree[u]-=1;
                if(inDegree[u]==0){
                    dq.addLast(u);
                }
            }
        }
        return count==numCourses;


    }
}
