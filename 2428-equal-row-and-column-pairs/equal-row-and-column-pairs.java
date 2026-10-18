class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rows = new HashMap<>();

        for (int[] row : grid) {
            String key = Arrays.toString(row);
            rows.put(key, rows.getOrDefault(key, 0) + 1);
        }

        int count = 0;

        for (int c = 0; c < n; c++) {
            int[] column = new int[n];

            for (int r = 0; r < n; r++) {
                column[r] = grid[r][c];
            }

            String key = Arrays.toString(column);
            count += rows.getOrDefault(key, 0);
        }

        return count;
    }
}