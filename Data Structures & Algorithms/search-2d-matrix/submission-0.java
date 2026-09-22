class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0, bottom = matrix.length - 1;
        int mid = 0;

        while (top <= bottom) {
            mid = top + ((bottom - top) / 2);
            int lastVal = matrix[mid].length - 1;
            if (matrix[mid][0] > target) {
                bottom = mid - 1;
            } else if (matrix[mid][lastVal] < target) {
                top = mid + 1;
            } else {
                break;
            }
        }

        int[] searchMatrix = matrix[mid];

        int left = 0, right = searchMatrix.length - 1;
        int secondMid;

        while (left <= right) {
            secondMid = left + ((right - left) / 2);

            if (searchMatrix[secondMid] < target) {
                left = secondMid + 1;
            } else if (searchMatrix[secondMid] > target) {
                right = secondMid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
