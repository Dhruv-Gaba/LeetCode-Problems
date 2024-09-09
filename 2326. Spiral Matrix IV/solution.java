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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int ans[][]=new int[m][n];
        for(int[] x:ans){
            Arrays.fill(x,-1);
        }
        int i=0;
        int j=0;
        while(head!=null){
            while(j<n && ans[i][j]==-1 && head!=null){
                ans[i][j++]=head.val;
                head=head.next;
            }
            j--;
            i++;
            while(i<m && ans[i][j]==-1 && head!=null){
                ans[i++][j]=head.val;
                head=head.next;
            }
            i--;
            j--;
            while(j>=0 && ans[i][j]==-1 && head!=null){
                ans[i][j--]=head.val;
                head=head.next;
            }
            i--;
            j++;
            while(i>=0 && ans[i][j]==-1 && head!=null){
                ans[i--][j]=head.val;
                head=head.next;
            }
            i++;
            j++;
        }
        return ans;
    }
}
