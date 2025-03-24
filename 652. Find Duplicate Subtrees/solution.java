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
    Map<String,Integer> map;
    List<TreeNode> list;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map=new HashMap<>();
        list=new ArrayList<>();
        traverse(root);
        return list;
    }
    public String traverse(TreeNode root){
        if(root==null){
            return "#";
        }
        String left=traverse(root.left);
        String right=traverse(root.right);
        String rep=left+','+right+','+root.val;
        map.put(rep,map.getOrDefault(rep,0)+1);
        if(map.get(rep)==2){
            list.add(root);
        }
        return rep;
    }
}
