class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            adj[u].add(new int[]{v,w});
        }
        int[] distance=new int[n+1];
       Arrays.fill(distance,(int)1e9);
        distance[k]=0;
        PriorityQueue<int[]> heap=new PriorityQueue<>((x,y)->Integer.compare(x[0],y[0]));
        heap.offer(new int[]{0,k});
        while(!heap.isEmpty()){
            int[] d=heap.poll();
            int time=d[0];
            int node=d[1];
            if (time > distance[node]) {
                continue;
            }
            for(int[] it:adj[node]){
                int next_node=it[0];
                int new_time=it[1];
                if(time+new_time<distance[next_node]){
                    heap.offer(new int[]{time+new_time,next_node});
                    distance[next_node]=time+new_time;
                }
            }
        }
       
        int ans=-1;
        for(int i=1;i<=n;i++){
            if(distance[i]==(int)1e9){
                return -1;
            }
            ans=Math.max(ans,distance[i]);
        }
        return ans;
    }
}
// class Pair{
//     int child;
//     int weight;
//     Pair(int a,int b){
//         this.child=a;
//         this.weight=b;
//     }
// }
// class Duo{
//     int dist;
//     int parent;
//     Duo(int a,int b){
//         this.dist=a;
//         this.parent=b;
//     }
// }