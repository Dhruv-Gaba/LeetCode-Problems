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
    TreeNode newRoot=new TreeNode(-1);
    TreeNode dummy=newRoot;
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        newRoot.right=new TreeNode(root.val);
        newRoot=newRoot.right;
        inorder(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return dummy.right;
    }
}
