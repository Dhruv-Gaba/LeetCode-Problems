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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode odd=head;
        ListNode even=head.next;
        ListNode temp1=odd;
        ListNode temp2=even;
        while(temp1!=null && temp1.next!=null && temp2!=null && temp2.next!=null){
            temp1.next=temp1.next.next;
            temp2.next=temp2.next.next;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        temp1.next=even;
        return head;
    }
}
