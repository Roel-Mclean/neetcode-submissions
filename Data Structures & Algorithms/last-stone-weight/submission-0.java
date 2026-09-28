class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone : stones) {
            heap.add(stone);
        }

        while (heap.size() > 1) {
            int largest = heap.poll();
            int secondLargest = heap.poll();
            if (largest > secondLargest) {
                heap.add(largest - secondLargest);
            }
        }

        if (heap.isEmpty()) {
            return 0;
        } else {
            return heap.peek();
        }
    }
}
