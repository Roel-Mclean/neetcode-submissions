class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] cache = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[0].length; j++) {
                cache[i][j] = -1;
            }
        }

        return dfs(obstacleGrid, 0, 0, cache);
    }

    private int dfs(int[][] grid, int row, int col, int[][] cache) {
        int ROWS = grid.length, COLS = grid[0].length;

        if (row == ROWS || col == COLS || grid[row][col] == 1) {
            return 0;
        }

        if (cache[row][col] > -1) {
            return cache[row][col];
        }

        if (row == ROWS - 1 && col == COLS - 1) {
            return 1;
        }

        cache[row][col] = dfs(grid, row + 1, col, cache) + dfs(grid, row, col + 1, cache);

        return cache[row][col];
    }
}