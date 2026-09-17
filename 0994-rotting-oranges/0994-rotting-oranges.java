class Solution {
    public int orangesRotting(int[][] grid) {
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        Queue<int[]> q=new ArrayDeque<>();
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    visited[i][j]=true;
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        int time=0;
        int rot=0;
        int row[]={-1,0,1,0};
        int col[]={0,1,0,-1};
        if(count==0){
            return 0;
        }
        while(!q.isEmpty()){
          int size=q.size();
          for(int j=0;j<size;j++){
            int[] curr=q.poll();
          int r=curr[0];
          int c=curr[1];
          
          for(int i=0;i<4;i++){
            int new_r=r+row[i];
            int new_c=c+col[i];
            if(new_r>=0 && new_r<grid.length && new_c>=0 && new_c<grid[0].length && visited[new_r][new_c]==false&&grid[new_r][new_c]==1){
                visited[new_r][new_c]=true;
                rot++;
                q.offer(new int[]{new_r,new_c});
                
            }
          }
          }
          time++;
        }
        
        if(rot!=count){
            return -1;
        }
        return time-1;

    }
}