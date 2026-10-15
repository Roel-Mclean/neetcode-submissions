class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        return dfs(0, 0, m, n, cache);
    }

    private int dfs(int row, int col, int rows, int cols, int[][] cache) {
        if (row == rows || col == cols) {
            return 0;
        }

        if (cache[row][col] > 0) {
            return cache[row][col];
        }
        if (row == rows - 1 && col == cols - 1) {
            return 1;
        }

        cache[row][col] = dfs(row + 1, col, rows, cols, cache) + dfs(row, col + 1, rows, cols, cache);

        return cache[row][col];
    }
}
