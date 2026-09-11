/*
// Definition for a Node.
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
    HashMap<Node,Node> map=new HashMap<>();
    public Node cloneGraph(Node node) {
        return helper(node);
    }
    public Node helper(Node node){
        if(node==null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node curr=new Node(node.val,new ArrayList<>());
        map.put(node,curr);
        for(Node next:node.neighbors){
            curr.neighbors.add(helper(next));
        }
        return curr;
    }
}