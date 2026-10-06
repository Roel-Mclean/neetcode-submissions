class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        int freshOranges = 0;
        int minutes = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    freshOranges++;
                }

                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (freshOranges > 0 && !queue.isEmpty()) {
            int qLength = queue.size();
            for (int i = 0; i < qLength; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : directions) {
                    int row = r + dir[0];
                    int col = c + dir[1];
                    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        queue.offer(new int[]{row, col});
                        freshOranges--;
                    }
                }
            }
            minutes++;
        }
        return freshOranges == 0 ? minutes : -1;
    }
}
