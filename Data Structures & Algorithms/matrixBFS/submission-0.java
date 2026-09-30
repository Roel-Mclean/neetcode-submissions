class Solution {
    public int shortestPath(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int length = 0;
        if (grid[0][0] == 1 || grid[ROWS - 1][COLS - 1] == 1) {
            return -1;
        }
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] visit = new int[ROWS][COLS];
        queue.add(new int[2]);
        visit[0][0] = 1;

        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                int[] point = queue.poll();
                int row = point[0], col = point[1];
                if (row == ROWS - 1 && col == COLS - 1) {
                    return length;
                }

                int[][] neighbours = {{row, col + 1}, {row, col - 1}, {row + 1, col}, {row - 1, col}};
                for (int j = 0; j < neighbours.length; j++) {
                    int newRow = neighbours[j][0], newCol = neighbours[j][1];
                    if (Math.min(newRow, newCol) < 0 || newRow == ROWS || newCol == COLS || visit[newRow][newCol] == 1 || grid[newRow][newCol] == 1) {
                        continue;
                    }
                    queue.add(neighbours[j]);
                    visit[newRow][newCol] = 1;
                }
            }
            length++;
        }

        return -1;
    }
}
