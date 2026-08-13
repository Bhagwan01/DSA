class Solution {
    public int[][] highestPeak(int[][] isWater) {
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<isWater.length;i++){
            for(int j=0;j<isWater[0].length;j++){
                if(isWater[i][j]==0){
                    isWater[i][j]=1;
                }else{
                    isWater[i][j]=0;
                }
            }
        }
        for(int i=0;i<isWater.length;i++){
            for(int j=0;j<isWater[0].length;j++){
                if(isWater[i][j]==0){
                    q.offer(new Pair(i,j));
                }else{
                    isWater[i][j]=-1;
                }
            }
        }
        int Row[]={-1,0,1,0};
        int Col[]={0,1,0,-1};
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.row;
            int c=p.col;
            for(int i=0;i<4;i++){
                int tr=r+Row[i];
                int tc=c+Col[i];
                if(tr>=0 && tr<isWater.length && tc>=0 && tc<isWater[0].length && isWater[tr][tc]==-1){
                    isWater[tr][tc]=isWater[r][c]+1;
                    q.offer(new Pair(tr,tc));

                }
            }
        }
        return isWater;
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