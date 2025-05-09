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
    class Info{
        TreeNode node;
        int level;
        public Info(TreeNode n,int l){
            this.node=n;
            this.level=l;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Map<Integer,TreeNode> map=new HashMap<>();
        int min=0;
        int max=0;
        Queue<Info> q=new LinkedList<>();
        q.add(new Info(root,0));
        while(!q.isEmpty()){
            Info curr=q.remove();
            if(!map.containsKey(curr.level)){
                map.put(curr.level,curr.node);
                min=Math.min(min,curr.level);
                max=Math.max(max,curr.level);
            }
            if(curr.node.right!=null){
                q.add(new Info(curr.node.right,curr.level+1));
            }
            if(curr.node.left!=null){
                q.add(new Info(curr.node.left,curr.level+1));
            }
        }
        for(int i=min;i<=max;i++){
            list.add(map.get(i).val);
        }
        return list;
    }
}
