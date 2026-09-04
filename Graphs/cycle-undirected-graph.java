import java.util.*;

// class Pair{
//     int first;
//     int second;
//     Pair(int first, int second){
//         this.first=first;
//         this.second=second;
//     }
// }

class Solution {
    
    public static boolean checkCycle(int src,ArrayList<ArrayList<Integer>> adj, int vis[], int n ){
        vis[src]=1;
        // Queue <Pair> q= new LinkedList<Pair> ();
        Queue <int []> q= new LinkedList<> ();
        q.add(new int[]{src,-1});
        
        while(!q.isEmpty()){
            int[] top = q.peek();
            int node = top[0];
            // int parent = q.peek().second;
            int parent=top[1];
            
            q.remove();
            
            for(int adjNode: adj.get(node)){
                if(vis[adjNode]==0){
                    vis[adjNode]=1;
                    // q.add(new Pair(adjNode,node));
                    q.add(new int[]{adjNode,node});
                }
                else if(adjNode!=parent){
                    return true;
                }
            }
        }
        return false;
        
    }
    public boolean isCycle(int n, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i=0; i<n;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int vis[] = new int[n];
        
        for(int i=0; i<n;i++){
            if(vis[i]==0){
                if(checkCycle(i,adj,vis,n)) return true;
            }
        }
        return false;
        
    }
}
