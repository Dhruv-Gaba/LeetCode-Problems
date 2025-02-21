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
    public static TreeNode root;

    public void recoverTree(TreeNode root, int val){
        if(root==null){
            return;
        }
        root.val=val;
        recoverTree(root.left,2*val+1);
        recoverTree(root.right,2*val+2);
    }
    public FindElements(TreeNode root) {
        this.root=root;
        root.val=0;
        recoverTree(root.left,1);
        recoverTree(root.right,2);
    }
    
    public boolean find(int target) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.remove();
            if(curr.val==target){
                return true;
            }
            if(curr.val>target){
                break;
            }
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
        }
        return false;

    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
