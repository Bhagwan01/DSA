class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int ans=0;
        int[] row={-1,0,1,0};
        int[] col={0,1,0,-1};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j]==false && grid[i][j]=='1'){
                    dfs(i,j,row,col,visited,grid);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(int r,int c,int[] row,int[] col,boolean[][] visited,char[][] grid){
        visited[r][c]=true;
        for(int i=0;i<4;i++){
            int next_r=r+row[i];
            int next_c=c+col[i];
            if(next_r>=0 && next_r<grid.length && next_c>=0 && next_c<grid[0].length && grid[next_r][next_c]=='1' && visited[next_r][next_c]==false){
                dfs(next_r,next_c,row,col,visited,grid);
            }
        }
    }
}