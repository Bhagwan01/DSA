class Solution {
    boolean ans=true;
    public boolean isBipartite(int[][] graph) {
        int[] visited=new int[graph.length];
        for(int i=0;i<visited.length;i++){
           if(visited[i]==0){
             dfs(i,-1,visited,graph); 
           }
        }
       
        return ans;
        
    }
    public void dfs(int node,int parent,int[] visited,int[][] graph){
        if(parent==-1){
            visited[node]=1;
            parent=1;
        }else{
            if(parent==1){
                visited[node]=2;
            }else{
                visited[node]=1;
            }
        }
        for(Integer it:graph[node]){
            if(visited[it]==0){
                dfs(it,visited[node],visited,graph);
            }else{
                if(visited[node]==visited[it]){   
                ans=false;
                return;
                }
            }
        }
    }
}