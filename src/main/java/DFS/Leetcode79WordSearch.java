package DFS;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 同一个单元格内的字母不允许被重复使用。
 示例:
 board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 给定 word = "ABCCED", 返回 true
 给定 word = "SEE", 返回 true
 给定 word = "ABCB", 返回 false

 */
public class Leetcode79WordSearch {
    private int [][] directions=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    private int m;
    private int n;
    private boolean [][] visited;
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || board[0].length==0){
            return false;
        }
        int m=board.length;
        int n=board[0].length;
        this.m=m;
        this.n=n;
        visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(i,j,0, word, board)){
                    return true;
                }
            }
        }
        return false;

    }
    public boolean dfs(int x, int y, int start, String word, char [][] board){
        if(start==word.length()-1){
            return word.charAt(start)==board[x][y];
        }
        if(word.charAt(start)==board[x][y]){
            visited[x][y]=true;
            for(int i=0;i<4;i++){
                int new_x=x+directions[i][0];
                int new_y=y+directions[i][1];
                if(isInArea(new_x,new_y)&& !visited[new_x][new_y]){
                    if(dfs(new_x, new_y, start+1, word, board)){
                        return true;
                    }

                }
            }
            visited[x][y]=false;
        }
        return false;

    }
    public boolean isInArea(int x,int y){
        if(x>=0 && x<=m-1 && y>=0 && y<=n-1){
            return true;
        }
        return false;
    }
}
