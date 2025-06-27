/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public void helper(Node head,List<Node> list){
        if(head==null){
            return;
        }
        list.add(head);
        if(head.child!=null){
            helper(head.child,list);
        }
        if(head.next!=null){
            helper(head.next,list);
        }
    }
    public Node flatten(Node head) {
        if(head==null || (head.next==null && head.child==null)){
            return head;
        }
        List<Node> list=new ArrayList<>();
        helper(head,list);
        Node dummy=new Node();
        Node temp=dummy;
        for(int i=1;i<list.size()-1;i++){
            list.get(i).child=null;
            list.get(i).prev=list.get(i-1);
            list.get(i).next=list.get(i+1);
        }
        list.get(0).next=list.get(1);
        list.get(0).prev=null;
        list.get(0).child=null;
        list.get(list.size()-1).next=null;
        list.get(list.size()-1).prev=list.get(list.size()-2);
        list.get(list.size()-1).child=null;
        return list.get(0);
    }
}
