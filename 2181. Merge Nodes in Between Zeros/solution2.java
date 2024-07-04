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
        while(temp.next!=null){
            sum+=temp.val;
            if(temp.next.val==0){
                node.next=new ListNode();
                node=node.next;
                node.val=sum;
                sum=0;
            }
            temp=temp.next;
        }
        return head.next;
    }
}
