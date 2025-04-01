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
    TreeNode prev;
    TreeNode first;
    TreeNode middle;
    TreeNode end;
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(prev!=null && (prev.val>=root.val)){
            if(first==null){
                first=prev;
                middle=root;
            }else{
                end=root;
            }
        }
        prev=root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first=middle=end=null;
        prev=null;
        inorder(root);
        if(first!=null && end!=null){
            int temp=first.val;
            first.val=end.val;
            end.val=temp;
        }else if(first!=null && middle!=null){
            int temp=first.val;
            first.val=middle.val;
            middle.val=temp;
        }
    }
}
