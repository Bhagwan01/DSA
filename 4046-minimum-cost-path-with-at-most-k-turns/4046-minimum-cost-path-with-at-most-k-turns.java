class Solution {
    public int minCost(int[][] grid, int k) {
        PriorityQueue<element> pq=new PriorityQueue<>((x,y)->Integer.compare(x.dist,y.dist));
        
        int[][][] distance=new int[grid.length][grid[0].length][4];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                Arrays.fill(distance[i][j],(int)1e9);
            }
        }
        int Row[]={-1,0,1,0};
        int Col[]={0,1,0,-1};
        // distance[0][0]=grid[0][0];
        pq.offer(new element(grid[0][0],0,0,-1,0));
        while(!pq.isEmpty()){
            element e=pq.poll();
            int d=e.dist;
            int row=e.r;
            int col=e.c;
            int direc=e.dir;
            int turns=e.turn;
            if(row==grid.length-1 && col==grid[0].length-1){
                return d;
            }
            if(direc!=-1 && turns>distance[row][col][direc]){
                continue;
            }
            if(direc!=-1){
                distance[row][col][direc]=turns;
            }
            
            for(int i=0;i<4;i++){
                int new_r=row+Row[i];
                int new_c=col+Col[i];
                
                if(new_r>=0 && new_r<grid.length && new_c>=0 && new_c<grid[0].length){
                  int next_turn=turns;
                    if(direc!=-1 && direc!=i ){
                        next_turn++;
                    }
                    if(next_turn<=k){
                        if(next_turn<distance[new_r][new_c][i]){
                            pq.offer(new element(d+grid[new_r][new_c],new_r,new_c,i,next_turn));
                        }
                    }
                }
                
            }

        }
            return -1;
        
        
    }
}
class element{
    int dist;
    int r,c,dir,turn;
    public element(int a,int b,int c,int d,int e){
        dist=a;
        r=b;
        this.c=c;
        dir=d;
        turn=e;
    }
}