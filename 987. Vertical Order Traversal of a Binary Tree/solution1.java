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

//DFS APPROACH
class Solution {
    int min=0;
    int max=0;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,PriorityQueue<int[]>> map=new HashMap<>();
        traversal(root,map,0,0);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=min;i<=max;i++){
            PriorityQueue<int[]> pq=map.get(i);
            List<Integer> temp=new ArrayList<>();
            while(!pq.isEmpty()){
                int[] list=pq.remove();
                temp.add(list[1]);
            }
            ans.add(temp);
            temp=new ArrayList<>();
        }
        return ans;
    }
    public void traversal(TreeNode root,Map<Integer,PriorityQueue<int[]>> map,int level,int hd){
        if(root==null){
            return;
        }
        min=Math.min(min,hd);
        max=Math.max(max,hd);
        map.computeIfAbsent(hd,k->new PriorityQueue<>(
                (a,b)->a[0]==b[0]?Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0])
            )).add(new int[]{level,root.val});
        traversal(root.left,map,level+1,hd-1);
        traversal(root.right,map,level+1,hd+1);
    }
}
