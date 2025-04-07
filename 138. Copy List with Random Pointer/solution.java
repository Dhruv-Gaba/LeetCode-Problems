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
        Node temp=head;
        Map<Node,Node> map=new HashMap<>();
        while(temp!=null){
            map.put(temp,new Node(temp.val));
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.next==null){
                map.get(temp).next=null;
            }
            else{
                map.get(temp).next=map.get(temp.next);
            }
            if(temp.random==null){
                map.get(temp).random=null;
            }
            else{
                map.get(temp).random=map.get(temp.random);
            }
            temp=temp.next;
        }
        return map.get(head);
    }
}
