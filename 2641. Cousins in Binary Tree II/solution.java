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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<Long> sumList=new ArrayList<>();
        while(!queue.isEmpty()){
            int size=queue.size();
            long sum=0;
            for(int i=0;i<size;i++){
                TreeNode currNode=queue.remove();
                sum+=currNode.val;
                if(currNode.left!=null){
                    queue.add(currNode.left);
                }
                if(currNode.right!=null){
                    queue.add(currNode.right);
                }
            }
            sumList.add(sum);
        }
        TreeNode node=root;
        dfs(node,1,sumList);
        root.val=0;
        return root;
    }
    private void dfs(TreeNode node,int count,List<Long> sumList){
        if(node==null || (node.left==null && node.right==null)){
            return;
        }
        int leftVal=node.left!=null?node.left.val:0;
        int rightVal=node.right!=null?node.right.val:0;
        if(node.left!=null){
            node.left.val=(int)(sumList.get(count)-leftVal-rightVal);
        }
        if(node.right!=null){
            node.right.val=(int)(sumList.get(count)-leftVal-rightVal);
        }
        dfs(node.left,count+1,sumList);
        dfs(node.right,count+1,sumList);

    }
}
