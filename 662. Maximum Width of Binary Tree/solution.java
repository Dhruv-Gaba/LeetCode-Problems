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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        root.val=0;
        q.add(root);
        int max=0;
        while(!q.isEmpty()){
            int n=q.size();
            int start=0;
            int end=0;
            for(int i=0;i<n;i++){
                TreeNode curr=q.poll();
                if(i==0){
                    start=curr.val;
                }
                if(i==n-1){
                    end=curr.val;
                }
                if(curr.left!=null){
                    curr.left.val=2*curr.val+1;
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    curr.right.val=2*curr.val+2;
                    q.add(curr.right);
                }
            }
            max=Math.max(max,end-start+1);
        }
        return max;
    }
}
