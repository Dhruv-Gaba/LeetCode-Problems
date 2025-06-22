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
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] ans=new int[list.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
    TreeNode prev=null;
    List<Integer> list=new ArrayList<>();
    int count=1;
    int maxCount=1;
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(prev!=null && prev.val==root.val){
            count++;
        }else{
            count=1;
        }
        if(maxCount<count){
            maxCount=count;
            list.clear();
            list.add(root.val);
        }
        else if(maxCount==count){
            list.add(root.val);
        }
        prev=root;
        inorder(root.right);
    }
}
