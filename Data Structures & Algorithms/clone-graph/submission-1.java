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
        Queue<Node> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();
        if(node == null){
            return node;
        }
        Node n = new Node(node.val);
        map.put(node.val,n);
        q.add(node);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size;i++){
                Node cur = q.poll();
                for(Node neighbor:cur.neighbors){
                    if(!map.containsKey(neighbor.val)){
                        Node new_neig = new Node(neighbor.val);
                        q.add(neighbor);
                        map.put(neighbor.val,new_neig);
                    }
                    map.get(cur.val).neighbors.add(map.get(neighbor.val));
                }
            }
        }
        return n;
    }
}