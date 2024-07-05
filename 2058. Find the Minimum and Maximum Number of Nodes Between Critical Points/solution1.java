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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode node=head;
        int min=Integer.MAX_VALUE;
        int prevIdx=-1;
        int currIdx=1;
        int firstIdx=-1;
        int lastIdx=-1;
        while(node.next.next!=null){
            if((node.next.val<node.val && node.next.val<node.next.next.val) || (node.next.val>node.val && node.next.val>node.next.next.val)){
                if(prevIdx==-1){
                    firstIdx=currIdx;
                    prevIdx=currIdx;
                }
                else{
                    min=Math.min(min,currIdx-prevIdx);
                    prevIdx=currIdx;
                }
            }
            currIdx++;
            node=node.next;
        }
        lastIdx=prevIdx;
        if(min==Integer.MAX_VALUE){
            int ans[]={-1,-1};
            return ans;
        }
        else{
            int ans[]={min,lastIdx-firstIdx};
            return ans;
        }
    }
}
