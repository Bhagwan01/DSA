class Solution {
    public void solve(char[][] board) {
        int[][] visited=new int[board.length][board[0].length];
        int m=board.length;
        int n=board[0].length;
        int row[]={-1,0,1,0};
        int col[]={0,1,0,-1};
        for(int i=0;i<n;i++){
            if(board[0][i]=='O' && visited[0][i]==0){
                dfs(0,i,row,col,visited,board);
            }
        }
        for(int i=0;i<n;i++){
            if(board[m-1][i]=='O' && visited[m-1][i]==0){
                dfs(m-1,i,row,col,visited,board);
            }
        }
        for(int i=0;i<m;i++){
            if(board[i][0]=='O' && visited[i][0]==0){
                dfs(i,0,row,col,visited,board);
            }
        }
        for(int i=0;i<m;i++){
            if(board[i][n-1]=='O' && visited[i][n-1]==0){
                dfs(i,n-1,row,col,visited,board);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && visited[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
        
        
    }
    public void dfs(int r,int c,int[] row,int[] col,int[][] visited,char[][] board){
     visited[r][c]=1;
     for(int i=0;i<4;i++){
        int tr=r+row[i];
        int tc=c+col[i];
        if(tr>=0 && tr<board.length && tc>=0 && tc<board[0].length && visited[tr][tc]==0 && board[tr][tc]=='O'){
            dfs(tr,tc,row,col,visited,board);
        }
     }
    }
    
}
class Pair{
    int row;
    int col;
    Pair(int a,int b){
        this.row=a;
        this.col=b;
    }
}