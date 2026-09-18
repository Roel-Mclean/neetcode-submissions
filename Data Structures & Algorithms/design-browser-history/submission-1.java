class BrowserHistory {

    Page currentPage;

    public BrowserHistory(String homepage) {
        this.currentPage = new Page(homepage);
    }
    
    public void visit(String url) {
        Page newPage = new Page(url);
        currentPage.next = newPage;
        newPage.prev = currentPage;
        currentPage = newPage;
    }
    
    public String back(int steps) {
        while (steps > 0 && currentPage.prev != null) {
            currentPage = currentPage.prev;
            steps--;
        }

        return currentPage.url;
    }
    
    public String forward(int steps) {
        while (steps > 0 && currentPage.next != null) {
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