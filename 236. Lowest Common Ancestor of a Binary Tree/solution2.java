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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1=new ArrayList<>();
        List<TreeNode> path2=new ArrayList<>();
        findPath(root,p.val,path1);
        findPath(root,q.val,path2);
        int i=0;
        while(i<path1.size() && i<path2.size() && path1.get(i)==path2.get(i)){
            i++;
        }
        return path1.get(i-1);
    }
    public boolean findPath(TreeNode root, int val, List<TreeNode> path){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.val==val){
            return true;
        }
        boolean foundLeft=findPath(root.left,val,path);
        boolean foundRight=findPath(root.right,val,path);
        if(foundLeft || foundRight){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
}
