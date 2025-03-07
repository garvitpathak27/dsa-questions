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
        Map<Node , Node > oldToNew  = new HashMap<>();
        return dfs(node , oldToNew);
    }
    private Node dfs(Node node , Map<Node , Node> oldtonew){
        if(node == null){
            return null;
        }
        if(oldtonew.containsKey(node)){
            return oldtonew.get(node);
        }

        Node copy = new Node(node.val);
        oldtonew.put(node , copy);

        for(Node n : node.neighbors){
            copy.neighbors.add(dfs(n , oldtonew));
        }
        return copy;
    }
}