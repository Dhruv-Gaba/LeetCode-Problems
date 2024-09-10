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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr=head;
        ListNode next=head.next;
        while(next!=null){
            int gcd=gcd(curr.val,next.val);
            ListNode temp=new ListNode();
            temp.val=gcd;
            curr.next=temp;
            temp.next=next;
            curr=next;
            next=next.next;
        }
        return head;
    }
    private int gcd(int n1,int n2){
        if(n2==0){
            return n1;
        }
        return gcd(n2,n1%n2);
    }
}
