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
    public int findSecondMinimumValue(TreeNode root) {
        int first=root.val;
        long second=Long.MAX_VALUE;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.remove();
            if(curr.val>first && curr.val<second){
                second=curr.val;
            }
            if(curr.left!=null){
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return second==Long.MAX_VALUE?-1:(int)second;
    }
}
