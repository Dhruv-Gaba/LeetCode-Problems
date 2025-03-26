/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        Map<TreeNode,TreeNode> map=new HashMap<>();
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr.left!=null){
                map.put(curr.left,curr);
                q.add(curr.left);
            }
            if(curr.right!=null){
                map.put(curr.right,curr);
                q.add(curr.right);
            }
        }
        Set<TreeNode> visited=new HashSet<>();
        visited.add(target);
        q.add(target);
        int dist=0;
        while(dist<k && !q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null && !visited.contains(curr.left)){
                    q.add(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right!=null && !visited.contains(curr.right)){
                    q.add(curr.right);
                    visited.add(curr.right);
                }
                if(map.get(curr)!=null && !visited.contains(map.get(curr))){
                    q.add(map.get(curr));
                    visited.add(map.get(curr));
                }
            }
            dist++;
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}
