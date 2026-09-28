class MinHeap {

    private List<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }

    public void push(int val) {
        heap.add(val);
        if (heap.size() == 2) {
            return;
        }

        int current = heap.size() - 1;

        while (current / 2 > 0) {
            if (heap.get(current) < heap.get(current / 2)) {
                int temp = heap.get(current);
                heap.set(current, heap.get(current / 2));
                heap.set(current / 2, temp);
            } else {
                break;
            }
            current = current / 2;
        }
    }

    public Integer pop() {
        if (heap.size() <= 1) {
            return -1;
        }

        int top = heap.get(1);

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int current = 1;

        while (current * 2 < heap.size()) {
            if (current*2 + 1 < heap.size() && heap.get(current*2 + 1) < heap.get(current*2) && heap.get(current) > heap.get(current*2 + 1)) {
                int temp = heap.get(current);
                heap.set(current, heap.get(current*2 + 1));
                heap.set(current*2 + 1, temp);
                current = current*2 + 1; 
            } else if (heap.get(current) > heap.get(current*2)) {
                int temp = heap.get(current);
                heap.set(current, heap.get(current*2));
                heap.set(current * 2, temp);
                current = current * 2;
            } else {
                break;
            }
        }

        return top;
    }

    public Integer top() {
        if (heap.size() <= 1) {
            return -1;
        }
        return heap.get(1);
    }

    public void heapify(List<Integer> nums) {
        if (nums.isEmpty()) {
            return;
        }
        heap = nums;
        heap.add(heap.get(0));

        int cur = heap.size() - 1 / 2;

        while (cur > 0) {
            int i = cur;

            while (i * 2 < heap.size()) {
            if (i*2 + 1 < heap.size() && heap.get(i*2 + 1) < heap.get(i*2) && heap.get(i) > heap.get(i*2 + 1)) {
                int temp = heap.get(i);
                heap.set(i, heap.get(i*2 + 1));
                heap.set(i*2 + 1, temp);
                i = i*2 + 1; 
            } else if (heap.get(i) > heap.get(i*2)) {
                int temp = heap.get(i);
                heap.set(i, heap.get(i*2));
                heap.set(i * 2, temp);
                i = i * 2;
            } else {
                break;
            }
        }

            cur -= 1;
        }
    }
}
