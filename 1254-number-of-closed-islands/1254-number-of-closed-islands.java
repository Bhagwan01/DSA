class Solution {
    public int closedIsland(int[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int ans=0;
        int[] row={-1,0,1,0};
        int[] col={0,-1,0,1};
        for(int i=0;i<grid[0].length;i++){
            if(grid[0][i]==0 && visited[0][i]==false){
                dfs(0,i,row,col,visited,grid);
            }
        }
        for(int i=0;i<grid[0].length;i++){
            if(grid[grid.length-1][i]==0 && visited[grid.length-1][i]==false){
                dfs(grid.length-1,i,row,col,visited,grid);
            }
        }
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]==0 && visited[i][0]==false){
                dfs(i,0,row,col,visited,grid);
            }
        }
        for(int i=0;i<grid.length;i++){
            if(grid[i][grid[0].length-1]==0 && visited[i][grid[0].length-1]==false){
                dfs(i,grid[0].length-1,row,col,visited,grid);
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]==0){
                   dfs(i,j,row,col,visited,grid);
                      ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(int r,int c,int[] row,int[] col,boolean[][] visited,int[][] grid){
        
            visited[r][c]=true;
        for(int i=0;i<4;i++){
            int next_r=r+row[i];
            int next_c=c+col[i];
            if(next_r>=0 && next_r<=grid.length-1 && next_c>=0 && next_c<=grid[0].length-1 && grid[next_r][next_c]==0 && visited[next_r][next_c]==false){
                dfs(next_r,next_c,row,col,visited,grid);
            }
        }
    }
}