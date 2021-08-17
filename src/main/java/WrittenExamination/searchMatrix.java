//package WrittenExamination;
//
//import java.util.Scanner;
//
//public class searchMatrix {
//
//    class UF{
//        private int count;//记录连通分量
//        private int [] parent;//节点x的节点是parent[x]
//        private int [] size;//为了避免树的不平衡，希望小的树接到大的树的下面，size[i]记录以i为节点的树的节点数
//        public UF(int n){//n为图的节点个数
//            //一开始互不连通
//            this.count=n;
//            //父节点指针初始指向自己
//            parent=new int[n];
//            //初始时每棵树只有一个节点
//            size=new int[n];
//            for(int i=0;i<n;i++){
//                parent[i]=i;
//                size[i]=1;
//            }
//        }
//        //连接两个节点，则让其中的一个节点的根节点接到另一个节点的根节点上
//        public void union(int p, int q){
//            //获得两个节点的父亲节点
//            int rootP=find(p);
//            int rootQ=find(q);
//            //如果p和q是同一棵树
//            if(rootP==rootQ){
//                return ;
//            }
//            //小树接在大数的下面
//            if(size[rootP]<size[rootQ]){
//                parent[rootP]=rootQ;
//                size[rootQ]+=size[rootP];
//            }else{
//                parent[rootQ]=rootP;
//                size[rootP]+=size[rootQ];
//            }
//
//            //合并之后连通分量减一
//            count--;
//
//        }
//        //返回某个节点x的根节点
//        public int find(int x){
//            //根节点：parent[x]=x
//            while(parent[x]!=x){
//                parent[x]=parent[parent[x]];
//                x=parent[x];
//            }
//            return x;
//        }
//        //返回连通分量的个数
//        public int count(){
//            return count;
//        }
//        //判断两个节点是否连通
//        public boolean isConnected(int p, int q){
//            int rootP=find(p);
//            int rootQ=find(q);
//            return rootP==rootQ;
//        }
//        public int getCount(){
//            return count;
//        }
//
//    }
//
//    public boolean isreached(char [][] matrix, int n, int m ){
//        UF uf=new UF(n*m);
//        //s表示王子，e表示公主
//        int  gz_x=0,gz_y=0;
//        int  wz_x=0,wz_y=0;
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                if(i==0){
//                    if(matrix[i][j]=='.' || matrix[i][j]=='S' || matrix[i][j]=='E'){
//                        if(matrix[i+1][j]=='.'){
//                            uf.union(i*m+j,(i+1)*m+j);
//                        }
//                        if(matrix[i][j+1]=='.'){
//                            uf.union(i*m+j,i*m+j+1);
//                        }
//
//                    }
//                }
//
//                if(j==0){
//                    if(matrix[i][j]=='.' || matrix[i][j]=='S' || matrix[i][j]=='E'){
//                        if(matrix[i][j+1]=='.'){
//                            uf.union(i*m+j,i*m+j+1);
//                        }
//                        if(matrix[i+1][j]=='.'){
//                            uf.union(i*m+j,(i+1)*m+j);
//                        }
//
//                    }
//                }
//
//                if(i>0 && j>0){
//                    if(matrix[i][j]=='.' || matrix[i][j]=='S' || matrix[i][j]=='E'){
//                        if(matrix[i][j+1]=='.' ||  matrix[i][j]=='S' || matrix[i][j]=='E'){
//                            uf.union(i*m+j,i*m+j+1);
//                        }
//                        if(matrix[i+1][j]=='.' || matrix[i][j]=='S' || matrix[i][j]=='E'){
//                            uf.union(i*m+j,(i+1)*m+j);
//                        }
//                        if(matrix[i+1][j]=='.' || matrix[i][j]=='S' || matrix[i][j]=='E'){
//                            uf.union(i*m+j,(i+1)*m+j);
//                        }
//
//                    }
//                }
//
//                if(matrix[i][j]=='S'){
//                    gz_x=i;
//                    gz_y=j;
//                }else if(matrix[i][j]=='E'){
//                    wz_x=i;
//                    wz_y=j;
//                }
//            }
//        }
//
//
//
//    }
//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        int T=in.nextInt();
//        for(int i=0;i<T;i++){
//            int n=in.nextInt();//行数
//            int m=in.nextInt();//列数
//            in.nextLine();
//            char [][] matrix=new char[n][m];
//            for(int x=0;x<n;x++){
//                String t=in.nextLine();
//                matrix[x]=t.toCharArray();
//            }
//
//        }
//    }
//}
