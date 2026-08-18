class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int[][] visited=new int[grid1.length][grid1[0].length];
        int[] row={-1,0,1,0};
        int[] col={0,1,0,-1};
        int ans=0;
        for(int i=0;i<grid1.length;i++){
            for(int j=0;j<grid1[0].length;j++){
                if(visited[i][j]==0 && grid2[i][j]==1){
                    Queue<Pair> st=new LinkedList<>();
                    dfs(i,j,visited,grid2,st,row,col);
                    if(isPresent(grid1,grid2,st)){
                        ans++;
                    }

                }
            }
        }
        return ans;
        
    }
    public void dfs(int r,int c,int[][] visited,int[][] grid2,Queue<Pair> st,int[] row,int[] col){
        visited[r][c]=1;
        st.offer(new Pair(r,c));
        for(int i=0;i<4;i++){
            int tr=r+row[i];
            int tc=c+col[i];
            if(tr>=0 && tr<grid2.length && tc>=0 && tc<grid2[0].length && visited[tr][tc]==0 && grid2[tr][tc]==1){
                dfs(tr,tc,visited,grid2,st,row,col);
            }
        }

    }
    public boolean isPresent(int[][] g1,int[][] g2,Queue<Pair> st){
        boolean ans=true;
        while(!st.isEmpty()){
            Pair p=st.poll();
            int r=p.Row;
            int c=p.Col;
            if(g1[r][c]==0){
           ans=false;
           break;
            }
        }
        return ans;
    }
}
class Pair{
    int Row;
    int Col;
    Pair(int a,int b){
        this.Row=a;
        this.Col=b;
    }
    
}
