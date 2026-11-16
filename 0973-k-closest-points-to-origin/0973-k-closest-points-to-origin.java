class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)->Integer.compare(x[0],y[0]));
        for(int i=0;i<points.length;i++){
            int a=points[i][0];
            int b=points[i][1];
            int sum=(a*a)+(b*b);
            
            pq.offer(new int[]{sum,i});
        }
        int[][] ans=new int[k][2];
        int i=0;
        while(i<k){
            int[] element=pq.poll();
            int idx=element[1];
            ans[i][0]=points[idx][0];
            ans[i][1]=points[idx][1];
            i++;
        }
        return ans;
    }

}