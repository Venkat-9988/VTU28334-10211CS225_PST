class BrowserHistory {
    private String[] history;
    private int current;
    private int max;

    public BrowserHistory(String homepage) {
        history = new String[5000];
        history[0] = homepage;
        current = 0;
        max = 0;
    }
    
    public void visit(String url) {
        current++;
        history[current] = url;
        max = current; // Clears all forward history
    }
    
    public String back(int steps) {
        current = Math.max(0, current - steps);
        return history[current];
    }
    
    public String forward(int steps) {
        current = Math.min(max, current + steps);
        return history[current];
    }
}
