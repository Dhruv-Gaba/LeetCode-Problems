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
        List<Integer> list=new ArrayList<Integer>();  
        int i=0;
        ListNode node=head;
        int min=Integer.MAX_VALUE;
        while(node.next.next!=null){
            if((node.next.val<node.val && node.next.val<node.next.next.val) || (node.next.val>node.val && node.next.val>node.next.next.val)){
                min=list.size()>0?Math.min(min,(i+1)-list.get(list.size()-1)):min;
                list.add(i+1);
            }
            i++;
            node=node.next;
        }
        int[] ans=new int[2];
        if(list.size()>=2){
            ans[0]=min;
            ans[1]=list.get(list.size()-1)-list.get(0);
        }
        else{
            ans[0]=-1;
            ans[1]=-1;
        }
        return ans;
    }
}
