class Graph {

    private Map<Integer, Set<Integer>> graph;

    public Graph() {
        this.graph = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        if (!graph.containsKey(src)) {
            graph.put(src, new HashSet<>());
        }

        if (!graph.containsKey(dst)) {
            graph.put(dst, new HashSet<>());
        }
        graph.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if (!graph.containsKey(src)) {
            return false;
        }
        Set<Integer> edges = graph.get(src);
        return edges.remove(dst);
    }

    public boolean hasPath(int src, int dst) {
        if (src == dst) {
            return true;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(src);
        visited.add(src);

        while (!queue.isEmpty()) {
            int qLength = queue.size();
            for (int i = 0; i < qLength; i++) {
                int node = queue.poll();
                if (node == dst) {
                    return true;
                }
                visited.add(node);
                for (int neighbour : graph.get(node)) {
                    if (!visited.contains(neighbour)) {
                        queue.offer(neighbour);
                    }
                }
            }
        }
        return false;
    }
}
