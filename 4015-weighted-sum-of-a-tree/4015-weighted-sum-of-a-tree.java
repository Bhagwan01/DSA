class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        List<List<Integer>> adj=new ArrayList<>();
        
        int height=0;
        for(int i=0;i<parent.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<parent.length;i++){
            if(parent[i]==-1){
                continue;
            }else{
                adj.get(parent[i]).add(i);
            }
        }
        
        long ans=0;
        int[] visited=new int[parent.length];
        HashMap<Integer,Integer> map=new HashMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(0,1));
        visited[0]=1;
        while(!q.isEmpty()){
            Pair p=q.poll();
            int curr=p.node;
            int depth=p.d;
            map.put(curr,depth);
            height=Math.max(height,depth);
            // ans=ans+(nums[curr]*(height-depth+1));
            //System.out.println(curr+" "+depth+" "+ans);
            for(Integer it:adj.get(curr)){
                if(visited[it]==0){
                    visited[it]=1;
                    q.offer(new Pair(it,depth+1));
                }
            }

        }
        for(int i=0;i<nums.length;i++){
            int dep=map.get(i);
            ans=ans+(long)(nums[i])*(height-dep+1);
        }
        return ans;

        
    }
}
class Pair{
    int node;
    int d;
    Pair(int a,int b){
        this.node=a;
        this.d=b;
    }
}