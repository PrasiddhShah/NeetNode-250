/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node dummy = new Node(-1);
        HashMap<Node,Node> map = new HashMap<>();
        Node copyhead = new Node(head.val);
        Node copycur = copyhead;
        Node cur = head;
        map.put(cur,copycur);
        while(cur != null){
           copycur.next = clone(cur.next,map);
           copycur.random = clone(cur.random,map);
           cur = cur.next;
           copycur = copycur.next;
        }
        return copyhead;
    }
    private Node clone(Node node,HashMap<Node,Node> map){
        if(node == null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node temp = new Node(node.val);
        map.put(node,temp);
        return temp;
    }
}
