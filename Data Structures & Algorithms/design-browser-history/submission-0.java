class BrowserHistory {

    Page head;
    Page tail;
    Page currentPage;

    public BrowserHistory(String homepage) {
        Page initialPage = new Page(homepage);
        this.head = initialPage;
        this.tail = initialPage;
        this.currentPage = initialPage;
    }
    
    public void visit(String url) {
        Page newPage = new Page(url);
        currentPage.next = newPage;
        newPage.prev = currentPage;
        tail = newPage;
        currentPage = newPage;
    }
    
    public String back(int steps) {
        while (steps > 0) {
            if (currentPage.prev == null) {
                return currentPage.url;
            }
            currentPage = currentPage.prev;
            steps--;
        }

        return currentPage.url;
    }
    
    public String forward(int steps) {
        while (steps > 0) {
            if (currentPage.next == null) {
                return currentPage.url;
            }
            currentPage = currentPage.next;
            steps--;
        }

        return currentPage.url;
    }
}

class Page {
    String url;
    Page next;
    Page prev;

    public Page(String url) {
        this(url, null, null);
    }

    public Page(String url, Page next, Page prev) {
        this.url = url;
        this.next = next;
        this.prev = prev;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */