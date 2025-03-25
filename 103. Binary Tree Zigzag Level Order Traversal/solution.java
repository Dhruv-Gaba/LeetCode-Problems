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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        int level=1;
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr==null){
                if(level%2==0){
                    Collections.reverse(temp);
                    ans.add(temp);
                }else{
                    ans.add(temp);
                }
                if(!q.isEmpty()){
                    q.add(null);
                }
                level++;
                temp=new ArrayList<>();
            }
            else{
                temp.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        return ans;
    }
}
