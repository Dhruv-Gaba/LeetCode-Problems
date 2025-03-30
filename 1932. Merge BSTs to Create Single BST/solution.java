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
    public boolean isValid(TreeNode root, TreeNode min, TreeNode max){
        if(root==null){
            return true;
        }
        if(min!=null && root.val<=min.val){
            return false;
        }
        if(max!=null && root.val>=max.val){
            return false;
        }
        return isValid(root.left,min,root) && isValid(root.right,root,max);

    }
    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer,TreeNode> map=new HashMap<>();
        int count=0;
        int n=trees.size();
        for(TreeNode x:trees){
            map.put(x.val,x);
        }
        for(TreeNode x:trees){
            if(count==n-1){
                break;
            }
            if(x.left!=null && map.containsKey(x.left.val)){
                if(map.get(x.left.val).right==null || map.get(x.left.val).right.val<x.val){
                    count++;
                    x.left=map.get(x.left.val);
                    map.remove(x.left.val);
                }
            }
            if(x.right!=null && map.containsKey(x.right.val)){
                if(map.get(x.right.val).left==null || map.get(x.right.val).left.val>x.val){
                    count++;
                    x.right=map.get(x.right.val);
                    map.remove(x.right.val);
                }
            }
        }
        TreeNode root=map.get(map.keySet().toArray()[0]);
        return count==n-1 && isValid(root,null,null)?root:null;

    }
}
