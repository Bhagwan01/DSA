class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        PriorityQueue<Item> pq=new PriorityQueue<>((x,y) -> Integer.compare(x.d,y.d));
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            adj.get(u).add(new Pair(v,w));
        }
        int[][] distance=new int[n][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<k+1;j++){
                distance[i][j]=(int)1e9;
            }
        }
        distance[0][1]=0;
        pq.offer(new Item(0,0,labels.charAt(0),1));
        while(!pq.isEmpty()){
            Item it=pq.poll();
            int dist=it.d;
            int curr_node=it.n;
            char prev_char=it.ch;
            int consecutive_count=it.c;
            if(dist>distance[curr_node][consecutive_count]) continue;
            for(int i=0;i<adj.get(curr_node).size();i++){
                int next_node=adj.get(curr_node).get(i).next;
                int weight=adj.get(curr_node).get(i).weigh;
                char curr_char=labels.charAt(next_node);
                int temp_conse_count=1;
                if(curr_char==prev_char){
                   temp_conse_count= consecutive_count+1;
                }
                if(temp_conse_count<=k && dist+weight<distance[next_node][temp_conse_count]  ){
                    distance[next_node][temp_conse_count]=dist+weight;
                    pq.offer(new Item(dist+weight,next_node,curr_char,temp_conse_count));
                }
            }
            
        }
        int ans=(int)1e9;
        for(int i=0;i<=k;i++){
            ans=Math.min(ans,distance[n-1][i]);
        }
        return ans==(int)1e9?-1:ans;
    }
}

class Item{
    int d;
    int n;
    char ch;
    int c;
    Item(int d,int n,char ch,int c){
        this.d=d;
        this.n=n;
        this.ch=ch;
        this.c=c;
    }
}
class Pair{
    int next;
    int weigh;
    Pair(int n,int w){
     next=n;
     weigh=w;
    }
}