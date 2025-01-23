/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }
        if(lists.length==1){
            return lists[0];
        }
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->(a.val-b.val));
        for(ListNode node:lists){
            if(node==null){
                continue;
            }
            pq.offer(node);
        }
        ListNode head=new ListNode(-1);
        ListNode temp=head;
        while(!pq.isEmpty()){
            ListNode node=pq.poll();
            temp.next=new ListNode(node.val);
            temp=temp.next;
            if(node.next!=null){
                node=node.next;
                pq.offer(node);
            }
        }
        return head.next;
    }
}
