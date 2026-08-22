class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row[]={-1,0,1,0};
        int col[]={0,1,0,-1};
        int effort[][]=new int[heights.length][heights[0].length];
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                effort[i][j]=(int)1e9;
            }
        }
        PriorityQueue<Pair> heap=new PriorityQueue<>((x,y) -> Integer.compare(x.d,y.d));
        //Queue<Pair> q=new ArrayDeque<>();
        effort[0][0]=0;
        heap.offer(new Pair(0,0,0));
        while(!heap.isEmpty()){
            Pair p=heap.poll();
            int distance=p.d;
            int Row=p.r;
            int Col=p.c;
            if(distance > effort[Row][Col]) continue;
            for(int i=0;i<4;i++){
                int tr=Row+row[i];
                int tc=Col+col[i];
                int newEff=distance;
                if(tr>=0 && tr<heights.length && tc>=0 && tc<heights[0].length){
                    int temp=Math.abs(heights[Row][Col]-heights[tr][tc]);
                    if(temp>distance) newEff=temp;
                    if(newEff<effort[tr][tc]){
                        effort[tr][tc]=newEff;
                        heap.offer(new Pair(newEff,tr,tc));
                    }
                }
            }

        }
        return effort[heights.length-1][heights[0].length-1];

    }
}
class Pair{
    int d;
    int r;
    int c;
    Pair(int a,int b,int c){
        this.d=a;
        this.r=b;
        this.c=c;
    }
}