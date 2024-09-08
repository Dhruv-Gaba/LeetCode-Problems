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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        int q=count/k;
        int rem=count%k;
        temp=head;
        int i=0;
        ListNode ans[]=new ListNode[k];
        int j=0;
        while(temp!=null){
            i=q+(rem>0?1:0);
            rem--;
            ans[j++]=temp;
            while(i>1){
                temp=temp.next;
                i--;
            }
            ListNode next=temp.next;
            temp.next=null;
            temp=next;
        }
        return ans;
    }
}
