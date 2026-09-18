class MyStack {

    Queue<Integer> forwardQ;

    public MyStack() {
        this.forwardQ = new LinkedList<>();
    }
    
    public void push(int x) {
        forwardQ.offer(x);
        for (int i = forwardQ.size() - 1; i > 0; i--) {
            forwardQ.offer(forwardQ.poll());
        }
    }
    
    public int pop() {
        return forwardQ.poll();
    }
    
    public int top() {
        return forwardQ.peek();
    }
    
    public boolean empty() {
        return forwardQ.isEmpty();
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