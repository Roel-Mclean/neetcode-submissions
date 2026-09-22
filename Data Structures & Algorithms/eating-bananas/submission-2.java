class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Arrays.stream(piles).max().getAsInt();
        int mid;

        int best = high;

        while (low <= high) {
            mid = low + ((high - low) / 2);
            int timeTaken = time(piles, mid);

            if (timeTaken <= h) {
                high = mid - 1;
                best = Math.min(best, mid);
            } else {
                low = mid + 1;
            }
        }

        return best;
    }

    private int time(int[] piles, int eatingSpeed) {
        int totalTime = 0;

        for (int pile : piles) {
            totalTime += Math.ceil((double) pile / eatingSpeed);
        }

        return totalTime;
    }
}
