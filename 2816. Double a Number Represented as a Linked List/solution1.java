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
        ListNode head1=new ListNode();
        head1.next=head;
        ListNode left=head1;
        ListNode right=head;
        while(right!=null){
            if(right.val*2>=10){
                left.val++;
            }
            right.val=(right.val*2)%10;
            right=right.next;
            left=left.next;
        }
        return head1.val>0?head1:head;
    }
}
