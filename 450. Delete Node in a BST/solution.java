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
    public TreeNode delete(TreeNode root,int key){
        if(root==null){
            return null;
        }
        if(root.val>key){
            root.left=delete(root.left,key);
        }else if(root.val<key){
            root.right=delete(root.right,key);
        }else{
            if(root.left==null && root.right==null){
                return null;
            }
            else if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }else{
                TreeNode IS=findInorderSuccessor(root.right);
                root.val=IS.val;
                root.right=delete(root.right,IS.val);
            }
        }
        return root;
    }
    public TreeNode findInorderSuccessor(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root,key);
    }
}
