//NICE APPROACH

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        int count1 = 0;
        ListNode ptr = head1;
        while(ptr!=null){
            ptr = ptr.next;
            count1++;
        }
        int count2 = 0;
        ptr = head2;
        while(ptr!=null){
            ptr = ptr.next;
            count2++;
        }
        int length1 = count1;
        int length2 = count2;
        while (length1 > length2) {
            head1 = head1.next;
            length1--;
        }
        while (length2 > length1) {
            head2 = head2.next;
            length2--;
        }
        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        
        return head1;
    }
}
