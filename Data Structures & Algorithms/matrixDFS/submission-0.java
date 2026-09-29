class Solution {
    public int countPaths(int[][] grid) {
        int[][] visit = new int[grid.length][grid[0].length];
        return dfs(grid, 0, 0, visit);
    }

    private int dfs(int[][] grid, int row, int col, int[][] visit) {

        int ROWS = grid.length;
        int COLS = grid[0].length;

        if (Math.min(row, col) < 0 || row == ROWS || col == COLS || visit[row][col] == 1 || grid[row][col] == 1) {
            return 0;
        }

        if (row == ROWS - 1 && col == COLS - 1) {
            return 1;
        }

        visit[row][col] = 1;

        int count = 0;
        count += dfs(grid, row + 1, col, visit);
        count += dfs(grid, row - 1, col, visit);
        count += dfs(grid, row, col + 1, visit);
        count += dfs(grid, row, col - 1, visit);

        visit[row][col] = 0;
        return count;
    }
}
