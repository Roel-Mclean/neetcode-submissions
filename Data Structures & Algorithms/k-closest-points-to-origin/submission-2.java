class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] orderedPoints = quickSort(points, 0, points.length - 1);

        return Arrays.copyOfRange(orderedPoints, 0, k);
    }

    private int[][] quickSort(int[][] points, int s, int e) {
        if (e - s + 1 <= 1) {
            return points;
        }

        int[] pivot = points[e];

        double pivotDistFromOrigin = distance(pivot);
        int left = s;

        for (int i = s; i < e; i++) {
            if (distance(points[i]) < pivotDistFromOrigin) {
                int[] tmp = points[i];
                points[i] = points[left];
                points[left] = tmp;
                left++;
            }
        }

        points[e] = points[left];
        points[left] = pivot;

        quickSort(points, s, left - 1);
        quickSort(points, left + 1, e);
        return points;
    }

    private double distance(int[] point) {
        return Math.sqrt((Math.pow(point[0], 2)) + (Math.pow(point[1], 2)));
    }
}
