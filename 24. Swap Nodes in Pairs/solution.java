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
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode curr=head;
        ListNode next=head.next;
        curr.next=next.next;
        next.next=curr;
        head=next;
        ListNode prev=curr;
        curr=curr.next;
        while(curr!=null && curr.next!=null){
            next=curr.next;
            curr.next=next.next;
            next.next=curr;
            prev.next=next;
            prev=curr;
            curr=curr.next;
        }
        return head;
    }
}
