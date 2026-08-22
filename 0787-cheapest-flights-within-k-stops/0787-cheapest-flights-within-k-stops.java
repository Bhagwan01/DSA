class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int w=flights[i][2];
            adj.get(u).add(new Pair(v,w));
        }
        int distance[]=new int[n];
        Arrays.fill(distance,(int)1e9);
        distance[src]=0;
        // PriorityQueue<Tri> heap=new PriorityQueue<>((x,y)-> Integer.compare(x.first,y.first));
        Queue<Tri> heap=new ArrayDeque<>();
        heap.offer(new Tri(0,0,src));
        int tar=k+1;
        while(!heap.isEmpty()){
            Tri t=heap.poll();
            int dist=t.first;
            int temp=t.sec;
            int node=t.third;
            //System.out.println(dist+" "+temp+" "+node+" "+distance[dst]);
            if(temp+1>tar) continue;
            for(int i=0;i<adj.get(node).size();i++){
                int child=adj.get(node).get(i).a;
                int weight=adj.get(node).get(i).b;
                if(dist+weight<distance[child] && temp+1<=tar){
                    distance[child]=dist+weight;
                    heap.offer(new Tri(dist+weight,temp+1,child));
                }
            }
        }
        if(distance[dst]==(int)1e9){
            return -1;
        }
        return distance[dst]; 

    }
    
}
class Tri{
    int first;
    int sec;
    int third;
    Tri(int l,int m,int n){
        this.first=l;
        this.sec=m;
        this.third=n;
    }
}
class Pair{
    int a;
    int b;
    Pair(int p,int q){
        this.a=p;
        this.b=q;
    }
}