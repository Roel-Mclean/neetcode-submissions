class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> sublist = new ArrayList<>();
        dfs(0, nums, sublist, output);
        return output;
    }

    private void dfs(int i, int[] nums, List<Integer> sublist, List<List<Integer>> output) {
        if (i >= nums.length) {
            output.add(new ArrayList<>(sublist));
            return;
        }

        sublist.add(nums[i]);
        dfs(i + 1, nums, sublist, output);

        sublist.remove(sublist.size() - 1);
        dfs(i + 1, nums, sublist, output);
    }
}
