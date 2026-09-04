import java.util.*;

class Pair{
    int row;
    int col;
    int tm;
    Pair(int row, int col,int tm){
        this.row=row;
        this.col=col;
        this.tm=tm;
    }
}

class Solution {
    public int orangesRot(int[][] mat) {
        // code here
        int n=mat.length;
        int m = mat[0].length;
        
        Queue<Pair> q = new LinkedList<Pair> ();
        int vis[][] = new int[n][m];
        int cntFresh=0;
        
        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                if(mat[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
                if(mat[i][j]==1){
                    cntFresh++;
                }
            }
        }
        
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        
        int cnt=0;
        int tm=0;
        
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            tm=Math.max(tm,t);
            
            for(int i=0; i<4;i++){
                int nrow=r+drow[i];
                int ncol = c+dcol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && mat[nrow][ncol]==1 ){
                    vis[nrow][ncol]=2;
                    cnt++;
                    q.add(new Pair(nrow, ncol, t+1));
                }
            }
            
        }
        
        if(cnt!=cntFresh) return -1;
        return tm;
    }
}
