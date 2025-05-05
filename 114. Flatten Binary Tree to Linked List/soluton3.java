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
    TreeNode prev=null;
    public void create(TreeNode root){
        if(root==null){
            return;
        }
        create(root.right);
        create(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
    }
    public void flatten(TreeNode root) {
        create(root);
    }
}
