/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum=0;
    public void sumInRange(TreeNode root,int low,int high){
        if(root==null){
            return;
        }
        if(root.val>=low && root.val<=high){
            sumInRange(root.left,low,high);
            sum+=root.val;
            sumInRange(root.right,low,high);
        }
        else if(root.val>high){
            sumInRange(root.left,low,high);
        }else{
            sumInRange(root.right,low,high);
        }
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        sumInRange(root,low,high);
        return sum;
    }
}
