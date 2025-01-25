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
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int x:nums){
            set.add(x);
        }
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            if(set.contains(temp.val)){
                count++;
            }
            while(temp!=null && set.contains(temp.val)){
                temp=temp.next;
            }
            if(temp!=null){
                temp=temp.next;
            }
        }
        return count;
    }
}
