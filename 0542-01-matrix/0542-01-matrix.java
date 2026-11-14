class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[] row={-1,0,1,0};
        int[] col={0,1,0,-1};
        int[][] mindist=new int[mat.length][mat[0].length];
        Queue<int[]> q=new ArrayDeque<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    mindist[i][j]=0;
                   q.offer(new int[]{i,j});
                }else{
                    mindist[i][j]=-1;
                }
            }
        }
        while(!q.isEmpty()){
            int ele[]=q.poll();
            int curr_r=ele[0];
            int curr_c=ele[1];
            for(int i=0;i<4;i++){
               int next_r=curr_r+row[i];
               int next_c=curr_c+col[i];
               if(next_r>=0 && next_r<mat.length && next_c>=0 && next_c<mat[0].length && mindist[next_r][next_c]==-1){
                mindist[next_r][next_c]=mindist[curr_r][curr_c]+1;
                q.offer(new int[]{next_r,next_c});
               }
            }
            
        }
        return mindist;
    }
}