class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int currentColour = image[sr][sc];
        if (currentColour == color) return image;
        helper(image, sr, sc, currentColour, color);
        return image;
    }

    private void helper(int[][] image, int row, int col, int curColour, int targetColour) {
        int ROWS = image.length;
        int COLS = image[0].length;

        if (Math.min(row, col) < 0 || row >= ROWS || col >= COLS || image[row][col] != curColour) {
            return;
        }

        image[row][col] = targetColour;

        helper(image, row + 1, col, curColour, targetColour);
        helper(image, row - 1, col, curColour, targetColour);
        helper(image, row, col + 1, curColour, targetColour);
        helper(image, row, col - 1, curColour, targetColour);
    }
}