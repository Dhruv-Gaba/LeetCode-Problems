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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode head=new ListNode(-1);
        ListNode list=head;
        int carry=0;
        while(temp1!=null && temp2!=null){
            int sum=carry+temp1.val+temp2.val;
            carry=sum/10;
            sum=sum%10;
            list.next=new ListNode(sum);
            list=list.next;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        while(temp1!=null){
            int sum=0;
            if(carry!=0){
                sum=carry+temp1.val;
                carry=sum/10;
                sum=sum%10;
            }
            else{
                sum=temp1.val;
            }
            list.next=new ListNode(sum);
            list=list.next;
            temp1=temp1.next;
        }
        while(temp2!=null){int sum=0;
            if(carry!=0){
                sum=carry+temp2.val;
                carry=sum/10;
                sum=sum%10;
            }
            else{
                sum=temp2.val;
            }
            list.next=new ListNode(sum);
            list=list.next;
            temp2=temp2.next;
        }
        if(carry!=0){
            ListNode newNode=new ListNode(carry);
            list.next=newNode;
        }
        return head.next;
    }
}
