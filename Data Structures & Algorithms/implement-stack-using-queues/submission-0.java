class MyStack {

    Queue<Integer> forwardQ;
    Queue<Integer> reverseQ;

    public MyStack() {
        this.forwardQ = new LinkedList<>();
        this.reverseQ = new LinkedList<>();
    }
    
    public void push(int x) {
        forwardQ.offer(x);
    }
    
    public int pop() {
        int count = 1;

        while (count < forwardQ.size()) {
            forwardQ.offer(forwardQ.poll());
            count++;
        }

        return forwardQ.poll();
    }
    
    public int top() {
        int count = 1;

        while (count < forwardQ.size()) {
            forwardQ.offer(forwardQ.poll());
            count++;
        }

        int top = forwardQ.poll();
        forwardQ.offer(top);

        return top;
    }
    
    public boolean empty() {
        return forwardQ.size() == 0 ? true : false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */