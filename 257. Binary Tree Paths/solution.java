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
    List<String> ans;
    public void path(TreeNode root, List<Integer> temp){
        if(root==null){
            return;
        }
        temp.add(root.val);
        if(root.left==null && root.right==null){
            addPath(temp);
        }
        path(root.left,temp);
        path(root.right,temp);
        temp.remove(temp.size()-1);
    }
    public void addPath(List<Integer> temp){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<temp.size();i++){
            sb.append(temp.get(i));
            if(i!=temp.size()-1){
                sb.append("->");
            }
        }
        ans.add(sb.toString());
    }
    public List<String> binaryTreePaths(TreeNode root) {
        ans=new ArrayList<>();
        path(root,new ArrayList<>());
        return ans;
    }
}
