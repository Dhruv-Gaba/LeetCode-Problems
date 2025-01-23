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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        ListNode left=head;
        for(int i=1;i<k && left!=null;i++){
            left=left.next;
        }
        ListNode right=head;
        for(int i=0;i<size-k;i++){
            right=right.next;
        }
        int t=left.val;
        left.val=right.val;
        right.val=t;
        return head;
    }
}
