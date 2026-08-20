class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row[]={-1,0,1,0,-1,1,-1,1};
        int col[]={0,1,0,-1,1,1,-1,-1};
        int[][] visited=new int[grid.length][grid[0].length];
        Queue<Triple> q=new LinkedList<>();
        if(grid[0][0]==1){
            return -1;
        }
        visited[0][0]=1;
        q.offer(new Triple(0,0,1));
        int ans=-1;
        while(!q.isEmpty()){
            Triple t=q.poll();
            int Row=t.r;
            int Col=t.c;
            int dist=t.dist;

            if(Row==grid.length-1 && Col==grid[0].length-1){
                ans=dist;
                return ans;
            }
            for(int i=0;i<8;i++){
                int tr=Row+row[i];
                int tc=Col+col[i];
                if(tr>=0 && tr<grid.length && tc>=0 && tc<grid[0].length && grid[tr][tc]==0 && visited[tr][tc]==0){
                    visited[tr][tc]=1;
                    q.offer(new Triple(tr,tc,dist+1));
                }
            }
            
        }
        return ans;
        
    }
    
}
class Triple{
    int r;
    int c;
    int dist;
    Triple(int a,int b,int k){
        this.r=a;
        this.c=b;
        this.dist=k;
    }
}