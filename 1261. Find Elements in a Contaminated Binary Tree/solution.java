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
class FindElements {
    Set<Integer> set=new HashSet<>();
    public void recoverTree(TreeNode root,int val){
        if(root==null){
            return;
        }
        set.add(val);
        recoverTree(root.left,2*val+1);
        recoverTree(root.right,2*val+2);
    }
    public FindElements(TreeNode root) {
        set.add(0);
        recoverTree(root.left,1);
        recoverTree(root.right,2);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
