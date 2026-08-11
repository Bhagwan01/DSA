class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans=new ArrayList<>();
        int[][] visited=new int[heights.length][heights[0].length];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<heights.length;i++){
            q.offer(new Pair(i,0));
            visited[i][0]=1;
        }
        for(int i=0;i<heights[0].length;i++){
            q.offer(new Pair(0,i));
            visited[0][i]=1;
        }
        int[] row={-1,0,1,0};
        int[] col={0,1,0,-1};
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.row;
            int c=p.col;
            for(int i=0;i<4;i++){
                int tr=r+row[i];
                int tc=c+col[i];
                if(tr>=0 && tr<heights.length && tc>=0 && tc<heights[0].length && visited[tr][tc]==0&& heights[r][c]<=heights[tr][tc]){
                    visited[tr][tc]=1;
                    q.offer(new Pair(tr,tc));
                }
            }
        }
        for(int i=0;i<heights.length;i++){
            if(visited[i][heights[0].length-1]==1){
                List<Integer> list=new ArrayList<>();
                list.add(i);
                list.add(heights[0].length-1);
                ans.add(list);
            }
            visited[i][heights[0].length-1]=2;
            q.offer(new Pair(i,heights[0].length-1));
        }
        for(int i=0;i<heights[0].length;i++){
            if(visited[heights.length-1][i]==1){
                List<Integer> list=new ArrayList<>();
                
                list.add(heights.length-1);
                list.add(i);
                ans.add(list);
            }
            visited[heights.length-1][i]=2;
            q.offer(new Pair(heights.length-1,i));
        }
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.row;
            int c=p.col;
            for(int i=0;i<4;i++){
                int tr=r+row[i];
                int tc=c+col[i];
                if(tr>=0 && tr<heights.length && tc>=0 && tc<heights[0].length && heights[r][c]<=heights[tr][tc]){
                  if(visited[tr][tc]==1){
                    List<Integer> list=new ArrayList<>();
                list.add(tr);
                list.add(tc);
                ans.add(list);
                  }
                  if(visited[tr][tc]==2) continue;
                  visited[tr][tc]=2;
                  q.offer(new Pair(tr,tc));

                }
               
            }
        }
        return ans;

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