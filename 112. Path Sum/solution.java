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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        return dfs(root,targetSum,0);
    }
    public boolean dfs(TreeNode root,int targetSum,int sum){
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            if(sum+root.val==targetSum){
                return true;
            }else{
                return false;
            }
        }
        boolean left=dfs(root.left,targetSum,root.val+sum);
        boolean right=dfs(root.right,targetSum,root.val+sum);
        return left||right;
    }
}
