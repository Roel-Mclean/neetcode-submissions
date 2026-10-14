/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> oldToNew = new HashMap<>();
        return node == null ? null : dfs(node, oldToNew);
    }

    Node dfs(Node node, Map<Integer, Node> oldToNew) {
        if (oldToNew.containsKey(node.val)) {
            return oldToNew.get(node.val);
        }

        Node copy = new Node(node.val);
        oldToNew.put(node.val, copy);

        for (Node neighbour : node.neighbors) {
            copy.neighbors.add(dfs(neighbour, oldToNew));
        }
        return copy;
    }
}