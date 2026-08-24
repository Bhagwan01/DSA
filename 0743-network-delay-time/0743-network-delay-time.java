class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            adj.get(u).add(new Pair(v,w));
        }
        int[] distance=new int[n+1];
        for(int i=0;i<=n;i++){
            distance[i]=(int)1e9;
        }
        distance[k]=0;
        PriorityQueue<Duo> heap=new PriorityQueue<>((x,y)->Integer.compare(x.dist,y.dist));
        heap.offer(new Duo(0,k));
        while(!heap.isEmpty()){
            Duo d=heap.poll();
            int time=d.dist;
            int node=d.parent;
            //if(time>)
            for(int i=0;i<adj.get(node).size();i++){
                int next_node=adj.get(node).get(i).child;
                int new_time=adj.get(node).get(i).weight;
                if(time+new_time<distance[next_node]){
                    heap.offer(new Duo(time+new_time,next_node));
                    distance[next_node]=time+new_time;
                }
            }
        }
        //System.out.println(Arrays.toString(distance));
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
class Pair{
    int child;
    int weight;
    Pair(int a,int b){
        this.child=a;
        this.weight=b;
    }
}
class Duo{
    int dist;
    int parent;
    Duo(int a,int b){
        this.dist=a;
        this.parent=b;
    }
}