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
    public ListNode mergeNodes(ListNode head) {
        ListNode node=head;
        ListNode temp=head;
        int sum=0;
        while(temp!=null){
            while(temp.val!=0){
                sum+=temp.val;
                temp=temp.next;
            }
            node.val=sum;
            temp=temp.next;
            node.next=temp;
            node=node.next;
            sum=0;
        }
        return head.next;
    }
}
