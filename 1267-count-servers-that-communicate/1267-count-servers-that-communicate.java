class Solution {
    public int countServers(int[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int servers=0;
        for(int i=0;i<grid.length;i++){
            int ones=0;
            int r=-1;int c=-1;
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    ones++;
                    servers++;
                    visited[i][j]=true;
                    if(ones==1){
                        r=i;c=j;
                    }
                }
            }
            if(ones==1){
                servers--;
                visited[r][c]=false;
            }
        }
        System.out.println(visited[0][0]);
        for(int i=0;i<grid[0].length;i++){
            int ones=0;
            int r=-1;int c=-1;
            for(int j=0;j<grid.length;j++){
                if(grid[j][i]==1 && visited[j][i]==true){
                    ones++;
                    visited[j][i]=false;
                    if(ones==1){
                        r=j;c=i;
                    }
                    continue;
                }
                if(grid[j][i]==1 ){
                    ones++;
                    servers++;
                    visited[j][i]=true;
                    if(ones==1){
                        r=j;c=i;
                    }
                }
            }
            if(ones==1 && visited[r][c]==true){
              servers--;
              visited[r][c]=false;
            }
        }
        return servers;
    }
}