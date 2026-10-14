class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        return dfs(n, 0, cache);     
    }

    private int dfs(int n, int i, int[] cache) {
        if (i >= n) return i == n ? 1 : 0;
        if (cache[i] != 0) return cache[i];
        cache[i] = dfs(n, i + 1, cache) + dfs(n, i + 2, cache);
        return cache[i];
    }
}
