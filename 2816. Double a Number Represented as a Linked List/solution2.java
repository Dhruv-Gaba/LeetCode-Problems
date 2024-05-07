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
    public ListNode doubleIt(ListNode head) {
        ListNode temp=rev(head);
        int carry=0;
        ListNode head1=temp;
        while(temp!=null){
            int num=temp.val;
            num*=2;
            temp.val=num%10;
            temp.val+=carry;
            carry=num/10;
            if(temp.next==null && carry!=0){
                temp.next=new ListNode(carry);
                temp=temp.next;
            }
            temp=temp.next;
            
        }
        return rev(head1);
    }
    public static ListNode rev(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode prev=null;
        ListNode curr=head;
        ListNode frwd=head;
        while(curr!=null){
            frwd=frwd.next;
            curr.next=prev;
            prev=curr;
            curr=frwd;
        }
        return prev;
    }
}
