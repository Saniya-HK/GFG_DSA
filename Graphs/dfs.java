import java.util.*;

class Solution {
    
    public void dfs (int node, ArrayList<Integer> dfsans,ArrayList<ArrayList<Integer>> adj, boolean vis[]  ){
        vis[node]=true;
        dfsans.add(node);
        
        for (Integer it : adj.get(node)){
            if(vis[it]==false){
                vis [it]=true;
                dfs(it,dfsans ,adj,vis);
            }
        }
    }
    
    
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        
        boolean vis[] = new boolean [n];
        ArrayList<Integer> dfsans  = new ArrayList<>();
        
        vis[0]=true;
        
        
        dfs(0,dfsans,adj,vis);
        
        return dfsans;
        
    }
}
