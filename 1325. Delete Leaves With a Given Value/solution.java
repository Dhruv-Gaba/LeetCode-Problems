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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        dfs(root,target);
        return root.val==target && root.left==null && root.right==null?null:root;
    }
    public void dfs(TreeNode root,int target){
        if(root==null){
            return;
        }
        if(root.left!=null && root.left.left==null && root.left.right==null){
            if(root.left.val==target){
                root.left=null;
            }
        }
        if(root.right!=null && root.right.left==null && root.right.right==null){
            if(root.right.val==target){
                root.right=null;
            }
        }
        dfs(root.left,target);
        dfs(root.right,target);
        if(root.left!=null && root.left.left==null && root.left.right==null){
            if(root.left.val==target){
                root.left=null;
            }
        }
        if(root.right!=null && root.right.left==null && root.right.right==null){
            if(root.right.val==target){
                root.right=null;
            }
        }
    }
}


//EXCELLENT CODE FROM SUBMISSIONS
// class Solution {
//     public TreeNode removeLeafNodes(TreeNode root, int target) {
//         if(root == null){
//             return null;
//         }
//         root.right = removeLeafNodes(root.right,target);
//         root.left = removeLeafNodes(root.left,target);
//         if(root.left == null && root.right == null && root.val == target){
//             return null;
//         }
//         return root;
//     }
// }
