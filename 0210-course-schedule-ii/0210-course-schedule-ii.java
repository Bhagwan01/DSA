class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
            adj[b].add(a);
        }
        Stack<Integer> topo=new Stack<>();
        boolean visited[]=new boolean[numCourses];
        boolean[] visited2=new boolean[numCourses];
        boolean isCycle=false;
        int[] pathVisited=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(isCycle==false && detectCycle(i,adj,visited2,pathVisited)){
                    isCycle=true;
                }
                dfs(i,adj,visited,topo);
            }
        }
        int[] ans=new int[numCourses];
        int idx=0;
        if(isCycle){
            return new int[0];
        }
        while(!topo.isEmpty()){
          ans[idx]=topo.pop();
          idx++;
        }
        return ans;
    }
    public void dfs(int node,List<Integer>[] adj,boolean[] visited,Stack<Integer> topo){
        visited[node]=true;
        for(int next:adj[node]){ 
            if(!visited[next]){
                dfs(next,adj,visited,topo);
            }
        }
        topo.push(node);
    }
    public boolean detectCycle(int node,List<Integer>[] adj,boolean[] visited2,int[] pathVisited){
        visited2[node]=true;
        pathVisited[node]=1;
        for(int next:adj[node]){
            if(!visited2[next]){
                if(detectCycle(next,adj,visited2,pathVisited)){
                    return true;
                }
            }else{
                if(pathVisited[next]==1){
                    return true;
                }
            }
        }
        pathVisited[node]=0;
        return false;
    }
}