class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int runningTotalOfOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                runningTotalOfOnes++;
            } else {
                maxOnes = Math.max(maxOnes, runningTotalOfOnes);
                runningTotalOfOnes = 0;
            }
        }
        return Math.max(maxOnes, runningTotalOfOnes);
    }
}