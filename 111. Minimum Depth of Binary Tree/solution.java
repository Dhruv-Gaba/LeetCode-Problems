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

//BFS - BETTER TC
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        int left=Integer.MAX_VALUE;
        int right=Integer.MAX_VALUE;
        if(root.left!=null){
            left=minDepth(root.left);
        }
        if(root.right!=null){
            right=minDepth(root.right);
        }
        return Math.min(left,right)+1;
    }
}
