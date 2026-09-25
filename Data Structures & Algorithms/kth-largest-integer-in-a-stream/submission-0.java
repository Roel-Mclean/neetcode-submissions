class KthLargest {

    int k;
    List<Integer> heap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new ArrayList<>();
        this.heap.add(0);

        for (int num : nums) {
            addToHeap(num);
        }
    }
    
    public int add(int val) {
        addToHeap(val);
        return heap.get(1);
    }

    private void addToHeap(int val) {
        heap.add(val);
        int i = heap.size() - 1;

        while (i > 1 && heap.get(i) < heap.get(i / 2)) {
            int tmp = heap.get(i);
            heap.set(i, heap.get(i / 2));
            heap.set(i / 2, tmp);
            i = i / 2;
        }

        if (heap.size() - 1 > k) {
            removeFromHeap();
        }
    }

    private void removeFromHeap() {
        if (heap.size() == 1) {
            return;
        }

        if (heap.size() == 2) {
            heap.remove(1);
            return;
        }

        heap.set(1, heap.remove(heap.size() - 1));
        int i = 1;

        while (2 * i < heap.size()) {
            if (2*i + 1 < heap.size() && heap.get(2*i + 1) < heap.get(2*i) && heap.get(i) > heap.get(2*i + 1)) {
                int tmp = heap.get(i);
                heap.set(i, heap.get(i*2 + 1));
                heap.set(i*2 + 1, tmp);
                i = i * 2 + 1;
            } else if (heap.get(i) > heap.get(2*i)) {
                int tmp = heap.get(i);
                heap.set(i, heap.get(i*2));
                heap.set(i*2, tmp);
                i = i * 2;
            } else {
                break;
            }
        }
    }
}
