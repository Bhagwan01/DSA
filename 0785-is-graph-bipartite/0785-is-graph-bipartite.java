class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] set=new int[graph.length];
        Arrays.fill(set,-1);
        set[0]=0;
        boolean[] visited=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(dfs(i,visited,set,graph)==false){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int node,boolean[] visited,int[] set,int[][] graph){
        visited[node]=true;
        for(int i=0;i<graph[node].length;i++){
            int next_node=graph[node][i];
            if(set[next_node]==-1){
                if(set[node]==0){
                    set[next_node]=1;
                }else{
                    set[next_node]=0;
                }
                if(!dfs(next_node,visited,set,graph)){
                    return false;
                }
            }else if(set[next_node]==set[node]){
                return false;
            }
        }
        return true;
    }
}