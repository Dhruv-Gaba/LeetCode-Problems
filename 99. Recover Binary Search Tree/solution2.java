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
    public void inorder(TreeNode root,List<TreeNode> list){
        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root);
        inorder(root.right,list);
    }
    public void recoverTree(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        inorder(root,list);
        int i=0;
        int j=list.size()-1;
        while(list.get(i).val<list.get(i+1).val){
            i++;
        }
        while(list.get(j).val>list.get(j-1).val){
            j--;
        }
        int temp=list.get(i).val;
        list.get(i).val=list.get(j).val;
        list.get(j).val=temp;
    }
}
