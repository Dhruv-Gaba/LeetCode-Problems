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
    //USE MERGE SORT FOR O(nlogn) TIME AND CONSTANT SPACE
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    public ListNode findMid(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode mergeSort(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid=findMid(head);
        ListNode rightHead=mid.next;
        mid.next=null;
        ListNode left=mergeSort(head);
        ListNode right=mergeSort(rightHead);
        return merge(left,right);
    }
    public ListNode merge(ListNode head1,ListNode head2){
        ListNode head;
        if(head1.val<=head2.val){
            head=head1;
            head1=head1.next;
        }
        else{
            head=head2;
            head2=head2.next;
        }
        ListNode temp=head;
        while(head1!=null && head2!=null){
            if(head1.val<=head2.val){
                temp.next=head1;
                head1=head1.next;
            }
            else{
                temp.next=head2;
                head2=head2.next;
            }
            temp=temp.next;
        }
        if(head1!=null){
            temp.next=head1;
        }
        if(head2!=null){
            temp.next=head2;
        }
        return head;
    }
}
