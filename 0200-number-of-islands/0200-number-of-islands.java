class Solution {
    public int numIslands(char[][] grid) {
        int[][] visited=new int[grid.length][grid[0].length];
        int ans=0;
        int row[]={-1,0,1,0};
        int col[]={0,1,0,-1};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    ans++;
                    dfs(i,j,visited,grid,row,col);
                }
            }
        }
        return ans;
    }
    public void dfs(int r,int c,int[][] visited,char[][] grid,int[] row,int[] col){
        visited[r][c]=1;
        for(int i=0;i<4;i++){
            int tr=r+row[i];
            int tc=c+col[i];
            if(tr>=0 && tr<grid.length && tc>=0 && tc<grid[0].length && visited[tr][tc]==0 && grid[tr][tc]=='1'){
                dfs(tr,tc,visited,grid,row,col);
            }
        }
    }
}