class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        List<Integer>[] adj=new ArrayList[parent.length];
        int height=0;
        for(int i=0;i<parent.length;i++){
           adj[i]=new ArrayList<>();
        }
        for(int i=1;i<parent.length;i++){
             adj[parent[i]].add(i);
            
        }
        
        long ans=0;
        int[] depth=new int[parent.length];
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(0);
        depth[0]=1;
        while(!q.isEmpty()){
            int curr=q.poll();
            int dep=depth[curr];
            height=Math.max(height,dep);
            for(Integer it:adj[curr]){
                    depth[it]=dep+1;
                    q.offer(it);
            }

        }
        for(int i=0;i<nums.length;i++){
            ans=ans+(long)(nums[i])*(height-depth[i]+1);
        }
        return ans;

        
    }
}
