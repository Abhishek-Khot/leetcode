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
    public HashMap<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        if(map.containsKey(head)){
            return map.get(head);
        }
        Node curr = new Node(head.val);
        map.put(head,curr);
        curr.next = copyRandomList(head.next);
        curr.random = copyRandomList(head.random);
        return curr;
    }
}