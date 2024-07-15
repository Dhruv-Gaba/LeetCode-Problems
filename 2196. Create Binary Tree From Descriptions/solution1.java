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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode> nodeMap=new HashMap<>();
        Set<Integer> children=new HashSet<>();
        for(int[] description:descriptions){
            int parentValue=description[0];
            int childValue=description[1];
            boolean isLeft=description[2]==1;

            if(!nodeMap.containsKey(parentValue)){
                nodeMap.put(parentValue,new TreeNode(parentValue));
            }
            if(!nodeMap.containsKey(childValue)){
                nodeMap.put(childValue,new TreeNode(childValue));
            }

            if(isLeft){
                nodeMap.get(parentValue).left=nodeMap.get(childValue);
            }
            else{
                nodeMap.get(parentValue).right=nodeMap.get(childValue);
            }

            children.add(childValue);
        }

        for(int key:nodeMap.keySet()){
            if(!children.contains(key)){
                return nodeMap.get(key);
            }
        }

        return null;
    }
}
