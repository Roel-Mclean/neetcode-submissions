class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] left = new int[m];
        int[] right = new int[n];

        for (int i = 0; i < m; i++) {
            left[i] = nums1[i];
        }

        for (int i = 0; i < n; i++) {
            right[i] = nums2[i];
        }

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if (left[i] <= right[j]) {
                nums1[k] = left[i];
                i++;
            } else {
                nums1[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            nums1[k] = left[i];
            i++;
            k++;
        }

        while (j < n) {
            nums1[k] = right[j];
            j++;
            k++;
        }
    }
}