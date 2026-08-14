class Solution {
        int row[]={-1,0,1,0};
        int col[]={0,1,0,-1};
    public int numEnclaves(int[][] grid) {
        int ans=0;
        int[][] visited=new int[grid.length][grid[0].length];
        int m=grid.length;
        int n=grid[0].length;

        for(int i=0;i<n;i++){
            if(grid[0][i]==1 && visited[0][i]==0){
                dfs(0,i,visited,grid);
            }
        }
        for(int i=0;i<n;i++){
            if(grid[m-1][i]==1 && visited[m-1][i]==0){
                dfs(m-1,i,visited,grid);
            }
        }
        for(int i=0;i<m;i++){
            if(grid[i][0]==1 && visited[i][0]==0){
                dfs(i,0,visited,grid);
            }
        }
        for(int i=0;i<m;i++){
            if(grid[i][n-1]==1 && visited[i][n-1]==0){
                dfs(i,n-1,visited,grid);
            }
        }
        //System.out.println(Arrays.deepToString(grid));
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    ans++;
                }
            }
        }
        return ans;


    }
    public void dfs(int r,int c,int[][] visited,int[][] grid){
        visited[r][c]=1;
        for(int i=0;i<4;i++){
            int tr=r+row[i];
            int tc=c+col[i];
            if(tr>=0 && tr<grid.length && tc>=0 && tc<grid[0].length && visited[tr][tc]==0 && grid[tr][tc]==1){
                dfs(tr,tc,visited,grid);
            }
        }
    }
}