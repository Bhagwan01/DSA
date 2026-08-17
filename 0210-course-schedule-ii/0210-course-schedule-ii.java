class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] visited1=new int[numCourses];
        int[] visited=new int[numCourses];
        Stack<Integer> st=new Stack<>();
        int[] pathVisited=new int[numCourses];
        boolean isCycle=false;
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(dfs2(i,visited1,adj,pathVisited)){
                    isCycle=true;
                }
                dfs(i,visited,adj,st);
            }
        }
        System.out.println(isCycle);
        int[] ans=new int[numCourses];
        if(isCycle){
            int temp[]={};
            return temp;
        }
        int idx=ans.length-1;
        while(!st.isEmpty()){
            ans[idx--]=st.pop();
        }
        return ans;
    }
    public void dfs(int node ,int[] visited,List<List<Integer>> adj,Stack<Integer> st){
        visited[node]=1;
        
        for(Integer it: adj.get(node)){
            if(visited[it]==0){
                dfs(it,visited,adj,st);
            }
        }
        st.push(node);
    }
     public boolean dfs2(int node,int[] visited,List<List<Integer>> adj,int[] pathVisited){
        visited[node]=1;
        pathVisited[node]=1;
        for(Integer it:adj.get(node)){
            if(visited[it]==0){
                if(dfs2(it,visited,adj,pathVisited)){
                    return true;
                }
            }else{
                if(pathVisited[it]==1){
                    return true;
                }

            }
        }
        pathVisited[node]=0;
        return false;
        
    }
    

}