class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row=new boolean[9][10];
        boolean[][] col=new boolean[9][10];
        boolean[][] box=new boolean[9][10];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char ch=board[i][j];
                if(ch=='.'){
                    continue;
                }
                int num=ch-'0';
                int boxidx=(i/3)*3+(j/3);
                if(row[i][num]||col[j][num]||box[boxidx][num]){
                    return false;
                }
                row[i][num]=true;
                col[j][num]=true;
                box[boxidx][num]=true;
            }
        }
        return true;
    }
}