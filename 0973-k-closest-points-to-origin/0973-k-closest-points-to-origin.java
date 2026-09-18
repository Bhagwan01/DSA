class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap=new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        for(int i=0;i<points.length;i++){
            int x=points[i][0];
            int y=points[i][1];
            int dist=(x*x)+(y*y);
            //System.out.println(dist);
            heap.offer(new int[]{dist,i});
            if(heap.size()>k){
                int[] temp=heap.poll();
            }
        }
        int[][] ans=new int[k][2];
        int i=0;
        while(!heap.isEmpty()){
            int[] curr=heap.poll();
            int idx=curr[1];
            ans[i][0]=points[idx][0];
            ans[i][1]=points[idx][1];
            i++;
        }
        return ans;
    }
}