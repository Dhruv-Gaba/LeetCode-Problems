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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>(Collections.reverseOrder());
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        while(!bfsQueue.isEmpty()){
            int size=bfsQueue.size();
            long sum=0;
            for(int i=0;i<size;i++){
                TreeNode poppedNode=bfsQueue.remove();
                sum+=poppedNode.val;
                if(poppedNode.left!=null){
                    bfsQueue.add(poppedNode.left);
                }
                if(poppedNode.right!=null){
                    bfsQueue.add(poppedNode.right);
                }
            }
            pq.add(sum);
        }
        if(pq.size()<k)return -1;
        for(int i=0;i<k-1;i++){
            pq.remove();
        }
        return pq.peek();
    }
}
