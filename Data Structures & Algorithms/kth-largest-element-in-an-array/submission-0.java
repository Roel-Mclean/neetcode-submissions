class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : nums) {
            maxHeap.offer(num);
        }

        int result = maxHeap.peek();

        for (int i = 0; i < k; i++) {
            result = maxHeap.poll();
        }

        return result;
    }
}
