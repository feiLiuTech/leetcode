package SwordOffer;

/**
 * 矩阵中是否存在给定的路径（字符串）
 */
public class SwordOffer12 {
    private int[][] dirctions=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    private int m,n;
    private boolean [][] visited;
    public boolean exist_20200831(char[][] board, String word) {
        if(board==null || board.length==0|| board[0].length==0){
            return false;
        }
        this.m=board.length;
        this.n=board[0].length;
        visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(i,j, 0, board, word)){
                    return true;
                }
            }
        }
        return false;

    }
    public  boolean dfs(int x, int y, int start, char [][]board, String word){
        if(start==word.length()-1){
            return word.charAt(start)==board[x][y];
        }

        if(board[x][y]==word.charAt(start)){
            visited[x][y]=true;
            for(int i=0;i<4;i++){
                int new_x=x+dirctions[i][0];
                int new_y=y+dirctions[i][1];
                if(new_x>=0&& new_x<m && new_y>=0 && new_y<n && !visited[new_x][new_y]){
                    if(dfs(new_x,new_y, start+1, board, word)){
                        return true;
                    }
                }
            }
            visited[x][y]=false;
        }
        return false;
    }


}
