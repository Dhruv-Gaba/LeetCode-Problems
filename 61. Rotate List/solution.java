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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null){
            return head;
        }
        ListNode tail=head;
        int size=1;
        while(tail.next!=null){
            tail=tail.next;
            size++;
        }
        tail.next=head;
        for(int i=0;i<size-(k%size);i++){
            head=head.next;
            tail=tail.next;
        }
        tail.next=null;
        return head;
    }
}
