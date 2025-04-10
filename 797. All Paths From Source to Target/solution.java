class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int src=0;
        int dest=graph.length-1;
        ans=new ArrayList<>();
        findPath(graph,src,dest,new ArrayList<>());
        return ans;
    }
    public void findPath(int[][] graph,int src,int dest,List<Integer> curr){
        if(src==dest){
            List<Integer> temp=new ArrayList<>();
            temp.addAll(curr);
            temp.add(src);
            ans.add(temp);
            return;
        }
        curr.add(src);
        for(int neighbour:graph[src]){
            findPath(graph,neighbour,dest,curr);
        }
         curr.remove(curr.size()-1);
    }
}
