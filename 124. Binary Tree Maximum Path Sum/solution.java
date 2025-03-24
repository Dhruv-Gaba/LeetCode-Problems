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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        traversal(root);
        return max;
    }
    public int traversal(TreeNode root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int left=traversal(root.left);
        int right=traversal(root.right);
        int curr=left<0?root.val:left+root.val;
        curr=right<0?curr:curr+right;
        max=Math.max(Math.max(left,right),Math.max(max,curr));
        int val1=left<0?root.val:left+root.val;
        int val2=right<0?root.val:root.val+right;
        return Math.max(val1,val2);
    }
}
