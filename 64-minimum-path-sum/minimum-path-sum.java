class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                if (r == 0 && c == 0) {
                    continue;
                }

                int up = (r > 0) ? grid[r - 1][c] : Integer.MAX_VALUE;
                int left = (c > 0) ? grid[r][c - 1] : Integer.MAX_VALUE;

                grid[r][c] += Math.min(up, left);
            }
        }

        return grid[m - 1][n - 1];
    }
}
