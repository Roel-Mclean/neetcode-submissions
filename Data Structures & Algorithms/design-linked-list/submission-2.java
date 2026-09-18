class MyLinkedList {

    ListNode head;
    ListNode tail;
    
    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        ListNode curr = head;
        if (index < 0) return -1;
        while (index > 0) {
            curr = curr.next;
            if (curr == null) {
                return -1;
            }
            index--;
        }

        return curr.val;
    }
    
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        if (head == null) {
            head = newHead;
            tail = newHead;
        } else {
            newHead.next = head;
            head.prev = newHead;
            head = newHead;
        }
    }
    
    public void addAtTail(int val) {
        ListNode newTail = new ListNode(val);

        if (tail == null) {
            tail = newTail;
            head = newTail;
        } else {
            newTail.prev = tail;
            tail.next = newTail;
            tail = newTail;
        }
    }
    
    public void addAtIndex(int index, int val) {
        ListNode newNode = new ListNode(val);
        ListNode curr = head;
        
        while (index > 0) {
            try {
                curr = curr.next;
                index--;
            } catch (NullPointerException npe) {
                return;
            }
        }

        if (curr == null) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else if (curr == head) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            ListNode prevNode = curr.prev;
            prevNode.next = newNode;
            newNode.prev = curr.prev;
            newNode.next = curr;
            curr.prev = newNode;
        }
    }
    
    public void deleteAtIndex(int index) {
        ListNode curr = head;
        while (index > 0) {
            curr = curr.next;
            if (curr == null) {
                return;
            }
            index--;
        }
        ListNode prevNode = curr.prev;
        ListNode nextNode = curr.next;

        if (prevNode != null) {
            prevNode.next = curr.next;
        }

        if (nextNode != null) {
            nextNode.prev = curr.prev;
        }

        if (curr == head) {
            head = nextNode;
        }

        if (curr == tail) {
            tail = prevNode;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    public ListNode() {
        this.next = null;
        this.prev = null;
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */