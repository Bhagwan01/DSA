class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int ans = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(i, j, grid1, grid2)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public boolean dfs(int r, int c, int[][] grid1, int[][] grid2) {
        if (r < 0 || r >= grid1.length || c < 0 || c >= grid1[0].length || grid2[r][c] == 0) {
            return true;
        }
        grid2[r][c] = 0;
        boolean issub = grid1[r][c] == 1;
        boolean up = dfs(r - 1, c, grid1, grid2);
        boolean down = dfs(r + 1, c, grid1, grid2);
        boolean left = dfs(r, c - 1, grid1, grid2);
        boolean right = dfs(r, c + 1, grid1, grid2);

        return issub && up && left && right && down;
    }
}