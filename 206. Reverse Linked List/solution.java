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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode frwd=head.next;
        ListNode curr=head.next;
        ListNode prev=head;
        while(frwd!=null){
            frwd=frwd.next;
            curr.next=prev;
            prev=curr;
            curr=frwd;
        }
        head.next=null;
        return prev;
    }
}
