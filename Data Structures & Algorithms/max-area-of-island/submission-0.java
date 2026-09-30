class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxSize = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1) {
                    maxSize = Math.max(maxSize, dfs(grid, i, j, ROWS, COLS));
                }
            }
        } 

        return maxSize;
    }

    private int dfs(int[][] grid, int row, int col, int ROWS, int COLS) {
        if (Math.min(row, col) < 0 || row == ROWS || col == COLS || grid[row][col] == 0) {
            return 0;
        }

        int size = 1;
        grid[row][col] = 0;

        size += dfs(grid, row + 1, col, ROWS, COLS);
        size += dfs(grid, row - 1, col, ROWS, COLS);
        size += dfs(grid, row, col + 1, ROWS, COLS);
        size += dfs(grid, row, col - 1, ROWS, COLS);

        return size;
    }
}
