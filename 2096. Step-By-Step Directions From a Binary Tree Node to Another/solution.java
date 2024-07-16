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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode LCA=findLCA(root,startValue,destValue);

        StringBuilder PathToStart=new StringBuilder();
        StringBuilder PathToDest=new StringBuilder();

        findPath(LCA,startValue,PathToStart);
        findPath(LCA,destValue,PathToDest);

        StringBuilder directions=new StringBuilder();

        for(int i=0;i<PathToStart.length();i++){
            directions.append('U');
        }

        directions.append(PathToDest);
        return directions.toString();
    }
    public static TreeNode findLCA(TreeNode node,int value1,int value2){
        if(node==null){
            return null;
        }
        if(node.val==value1 || node.val==value2){
            return node;
        }

        TreeNode LLCA=findLCA(node.left,value1,value2);

        TreeNode RLCA=findLCA(node.right,value1,value2);

        if(LLCA==null){
            return RLCA;
        }
        else if(RLCA==null){
            return LLCA;
        }
        else{
            return node;
        }
    }
    public static boolean findPath(TreeNode node, int target, StringBuilder path){
        if(node==null){
            return false;
        }
        if(node.val==target){
            return true;
        }

        path.append('L');
        if(findPath(node.left,target,path)){
            return true;
        }
        path.setLength(path.length()-1);

        path.append('R');
        if(findPath(node.right,target,path)){
            return true;
        }
        path.setLength(path.length()-1);

        return false;
    }
}
