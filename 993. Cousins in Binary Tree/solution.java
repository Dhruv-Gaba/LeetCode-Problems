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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root.val==x || root.val==y){
            return false;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            int count=0;
            for(int i=0;i<size;i++){
                TreeNode curr=q.remove();
                if(curr.val==x || curr.val==y){
                    count++;
                }
                if(curr.left!=null && curr.right!=null){
                    if((curr.left.val==x && curr.right.val==y) || (curr.left.val==y && curr.right.val==x)){
                        return false;
                    }
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            if(count==1){
                return false;
            }
            else if(count==2){
                return true;
            }
        }
        return true;
    }
}
