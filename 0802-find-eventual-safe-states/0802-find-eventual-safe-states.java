class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] visited=new int[graph.length];
        int[] pathVisited=new int[graph.length];
        int check[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(visited[i]==0){
                dfs(i,visited,graph,pathVisited,check);
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<check.length;i++){
            if(check[i]==1){
                list.add(i);
            }
        }
        Collections.sort(list);
        return list;

    }
    public boolean dfs(int node,int[] visited,int[][] graph,int[] pathVisited,int[] check){
        visited[node]=1;
        pathVisited[node]=1;
        check[node]=0;
        for(Integer it:graph[node]){
            if(visited[it]==0){
                if(dfs(it,visited,graph,pathVisited,check)){
                    return true;
                }
            }else{
                if(pathVisited[it]==1){
                    return true;
                }
            }
        }
        check[node]=1;
        pathVisited[node]=0;
        return false;
    }
}