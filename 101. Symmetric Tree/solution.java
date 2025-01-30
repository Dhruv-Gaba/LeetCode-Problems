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
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left,root.right);  
    }
    public boolean dfs(TreeNode leftRoot,TreeNode rightRoot){
        if(leftRoot==null && rightRoot==null){
            return true;
        }
        if(leftRoot==null || rightRoot==null){
            return false;
        }
        if(leftRoot.val!=rightRoot.val){
            return false;
        }
        boolean way1=dfs(leftRoot.left,rightRoot.right);
        boolean way2=dfs(leftRoot.right,rightRoot.left);
        return way1 && way2;
    }
}
