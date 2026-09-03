

import java.util.*;

class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second=second;
    }
}

public class Solution 
{
    public static void bfs(int row,int col, int[][]vis, char [][]mat){
        int n = mat.length;
        int m = mat[0].length;

        vis[row][col]=1;
        Queue<Pair> q = new LinkedList<Pair> ();

        q.add(new Pair(row,col));

        while(!q.isEmpty()){
            int r=q.peek().first;
            int c = q.peek().second;
            q.remove();

            for(int delrow=-1; delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1; delcol++){
                    int nrow =r+delrow;
                    int ncol = c+delcol;

                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && mat[nrow][ncol]=='L'){
                        vis[nrow][ncol]=1;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }
        }
    }

    public int countIslands(char[][] mat)
	{
        //Your code goes here
        int n = mat.length;
        int m = mat[0].length;

        int vis[][] = new int[n][m];
        int cnt=0;

        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                if(vis[i][j]==0 && mat[i][j]=='L'){
                    cnt++;
                    bfs(i,j,vis,mat);
                }
            }
        }
        return cnt;
    }
}
