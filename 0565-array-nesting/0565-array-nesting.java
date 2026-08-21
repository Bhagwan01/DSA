class Solution {
    int temp=0;
    public int arrayNesting(int[] nums) {
        int[] visited=new int[nums.length];
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(visited[i]==0){
              temp=0;
              dfs(i,visited,nums);
              ans=Math.max(temp,ans);
            }
        }
        return ans;
    }
    public void dfs(int node,int[] visited,int[] nums){
        visited[node]=1;
        temp++;
            if(nums[node]!=node && visited[nums[node]]==0){
                dfs(nums[node],visited,nums);
            }
        
    }
}