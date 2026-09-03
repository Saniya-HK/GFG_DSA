import java.util.*;

class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue <Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n];
        
        q.add(0);
        vis[0]=true;
        
        while(!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);
            
            for (Integer it: adj.get(node)){
                if (vis[it]==false){
                    vis[it]=true;
                    q.add(it);
                }
            }
            
        }
        
        return bfs;
        
        
    }
}
