/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode dfs(TreeNode original,TreeNode cloned,TreeNode target){
        if(original==target){
            return cloned;
        }
        if(original==null){
            return null;
        }
        TreeNode left=dfs(original.left,cloned.left,target);
        if(left!=null){
            return left;
        }
        TreeNode right=dfs(original.right,cloned.right,target);
        if(right!=null){
            return right;
        } 
        return null; 
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return dfs(original,cloned,target);

    }
}
