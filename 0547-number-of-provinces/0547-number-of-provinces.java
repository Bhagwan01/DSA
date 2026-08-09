class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<isConnected[i].length;j++){
               if(isConnected[i][j]==1){
                temp.add(j);
               }
            }
            adj.add(temp);
        }
        boolean[] visited=new boolean[adj.size()];
        int ans=0;
        for(int i=0;i<visited.length;i++){
            if(visited[i]==false){
                ans++;
                dfs(i,visited,adj);
            }
        }       
        return ans;
    }
    public void dfs(int node,boolean[] visited,List<List<Integer>> adj){
        visited[node]=true;
        for(Integer temp:adj.get(node)){
            if(visited[temp]==false){
                dfs(temp,visited,adj);
            }
        }
    }
}