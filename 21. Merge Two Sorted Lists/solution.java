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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node;
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        if(list1.val<=list2.val){
            node=list1;
            list1=list1.next;
        }
        else{
            node=list2;
            list2=list2.next;
        }
        ListNode head=node;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                node.next=list1;
                list1=list1.next;
            }
            else{
                node.next=list2;
                list2=list2.next;
            }
            node=node.next;
        }
        if(list1!=null){
            node.next=list1;
        }
        if(list2!=null){
            node.next=list2;
        }
        return head;
    }
}
