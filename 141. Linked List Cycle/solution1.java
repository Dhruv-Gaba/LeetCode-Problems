/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        ListNode rabbit=head;
        ListNode turtle=head;
        while(rabbit!=null && rabbit.next!=null){
            rabbit=rabbit.next.next;
            turtle=turtle.next;
            if(rabbit==turtle)return true;
        }
        return false;
    }
}
