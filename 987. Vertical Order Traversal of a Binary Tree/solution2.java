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

//BFS APPROACH
class Solution {
    class Info{
        int level;
        int hd;
        TreeNode node;
        public Info(TreeNode node,int level,int hd){
            this.node=node;
            this.hd=hd;
            this.level=level;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,PriorityQueue<int[]>> map=new HashMap<>();
        Queue<Info> q=new LinkedList<>();
        int min=0;
        int max=0;
        q.add(new Info(root,0,0));
        while(!q.isEmpty()){
            Info curr=q.poll();
            map.computeIfAbsent(curr.hd,k->new PriorityQueue<>(
                (a,b)->a[0]==b[0]?Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0])
            )).add(new int[]{curr.level,curr.node.val});
            if(curr.node.left!=null){
                q.add(new Info(curr.node.left,curr.level+1,curr.hd-1));
                min=Math.min(min,curr.hd-1);
            }
            if(curr.node.right!=null){
                q.add(new Info(curr.node.right,curr.level+1,curr.hd+1));
                max=Math.max(max,curr.hd+1);
            }
        }
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
}
