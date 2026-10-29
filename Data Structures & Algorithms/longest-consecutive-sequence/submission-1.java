class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int maxConsecutive = 1;
        int consecutive = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] == 1) {
                consecutive++;
            } else if (nums[i + 1] - nums[i] == 0) {
                continue;
            } else {
                maxConsecutive = Math.max(maxConsecutive, consecutive);
                consecutive = 1;
            }
        }
        return Math.max(maxConsecutive, consecutive);
    }
}
