class Solution {
    public int orangesRotting(int[][] grid) {
        int ans = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int fresh=0;
        int rotten=0;
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    visited[i][j]=true;
                    q.offer(new Pair(i,j));
                    
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        int[] row = {-1,0,1,0};
        int[] col = {0,1,0,-1};
        
        while (!q.isEmpty()) {
            int size=q.size();
            for (int z = 0; z < size; z++) {
                Pair p = q.poll();
                int i = p.row;
                int j = p.col;
                for (int k = 0; k < 4; k++) {
                   int t1 = i + row[k];
                    int t2 = j + col[k];
                    if (t1 >= 0 && t1 < grid.length && t2 >= 0 && t2 < grid[0].length && visited[t1][t2] == false && grid[t1][t2]==1) {
                        visited[t1][t2] = true;
                        rotten++;
                        q.offer(new Pair(t1, t2));
                    }
                }
            }
            ans++;
        }
        if(rotten!=fresh){
            return -1;
        }
        return ans-1;

    }
}

class Pair {
    int row;
    int col;

    Pair(int a, int b) {
        this.row = a;
        this.col = b;
    }
}