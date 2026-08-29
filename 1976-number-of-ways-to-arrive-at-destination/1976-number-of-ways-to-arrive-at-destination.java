class Solution {
    public int countPaths(int n, int[][] roads) {
        List<int[]>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int w=roads[i][2];
            adj[u].add(new int[]{v,w});
            adj[v].add(new int[]{u,w});
        }
        long[] distance=new long[n];
        int[] ways=new int[n];
        for(int i=0;i<n;i++){
            distance[i]=Long.MAX_VALUE;
            ways[i]=0;
        }
        distance[0]=0;
        ways[0]=1;
        PriorityQueue<long[]> heap=new PriorityQueue<>((x,y)->Long.compare(x[0],y[0]));
        heap.offer(new long[]{0,0});
        int mod=1000000007;
        while(!heap.isEmpty()){
            long[] curr=heap.poll();
            long dist=curr[0];
            int node=(int)curr[1];
            if(dist > distance[node]) continue;
            for(int[] next:adj[node]){
                long next_dist=next[1];
                int next_node=next[0];
                if(dist+next_dist<distance[next_node]){
                    heap.offer(new long[]{dist+next_dist,next_node});
                    distance[next_node]=dist+next_dist;
                    ways[next_node]=ways[node];
                }else if(dist+next_dist==distance[next_node]){
                    ways[next_node]=(ways[next_node]+ways[node])%mod;
                }
            }
        }
        return (int) ways[n-1];

    }
}