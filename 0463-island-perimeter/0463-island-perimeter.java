class Solution {
    public int islandPerimeter(int[][] grid) {
        int[][] visited=new int[grid.length][grid[0].length];
        int row[]={-1,0,1,0};
        int col[]={0,1,0,-1};
        Queue<Pair> q=new ArrayDeque<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                 q.offer(new Pair(i,j));
                 visited[i][j]=1;
                 break;
                }
            }
        }
         int ans=0;
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.first;
            int c=p.sec;
            int temp=0;
            for(int i=0;i<4;i++){
                int tr=r+row[i];
                int tc=c+col[i];
                if(tr>=0 && tr<grid.length && tc>=0 && tc<grid[0].length && visited[tr][tc]==0&& grid[tr][tc]==1){
                    visited[tr][tc]=1;
                    q.offer(new Pair(tr,tc));
                    temp++;
                }else if(tr>=0 && tr<grid.length && tc>=0 && tc<grid[0].length && visited[tr][tc]==1&& grid[tr][tc]==1){
                    temp++;
                }
            }
            ans+=4-temp;
        }
        return ans;
        
       
        
        
    }
}
class Pair{
    int first;
    int sec;
    Pair(int a,int b){
        this.first=a;
        this.sec=b;
    }
}