class Solution {
    public int maxProfit(int[] prices) {
        int left = Integer.MAX_VALUE, right = 0, maxProfit = 0;

        for (int price : prices) {
            if (price < left) {
                left = price;
                right = 0;
            } else if (price > right) {
                right = price;
                maxProfit = Math.max(maxProfit, right - left);
            }
        }

        return maxProfit;
    }
}
