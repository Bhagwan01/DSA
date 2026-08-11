class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited=new boolean[image.length][image[0].length];
        Queue<Pair> q=new LinkedList<>();
        int temp=image[sr][sc];
        q.offer(new Pair(sr,sc));
        visited[sr][sc]=true;
        image[sr][sc]=color;
        int row[]={-1,0,1,0};
        int col[]={0,1,0,-1};
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair p=q.poll();
                int r=p.row;
                int c=p.col;
                for(int j=0;j<4;j++){
                    int temp_r=r+row[j];
                    int temp_c=c+col[j];
                    if(temp_r>=0 && temp_r<image.length && temp_c>=0 && temp_c<image[0].length && visited[temp_r][temp_c]==false&& image[temp_r][temp_c]==temp){
                        visited[temp_r][temp_c]=true;
                        image[temp_r][temp_c]=color;
                        q.offer(new Pair(temp_r,temp_c));
                    }
                }
            }
        }
        return image;
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