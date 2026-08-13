class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    q.offer(new Pair(i,j));
                }else{
                    mat[i][j]=-1;
                }
            }
        }
         int row[]={-1,0,1,0};
        int col[]={0,1,0,-1};
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.ROW;
            int c=p.COL;
            for(int i=0;i<4;i++){
                int tr=r+row[i];
                int tc=c+col[i];
                if(tr>=0 && tr<mat.length && tc>=0 && tc<mat[0].length && mat[tr][tc]==-1){
                    mat[tr][tc]=mat[r][c]+1;
                    q.offer(new Pair(tr,tc));
                }
            }
        }
        return mat;
        
    }

    
}

class Pair {
    int ROW;
    int COL;

    Pair(int a, int b) {
        this.ROW = a;
        this.COL = b;
    }
}