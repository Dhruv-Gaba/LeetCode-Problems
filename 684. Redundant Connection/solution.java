class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer,List<Integer>> adjList=new HashMap<>();
        int n=edges.length;
        for(int edge[]:edges){
            boolean[] visited=new boolean[n];
            if(isConnected(adjList,visited,edge[0],edge[1])){
                return new int[]{edge[0],edge[1]};
            }
            adjList.computeIfAbsent(edge[0],k->new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1],k->new ArrayList<>()).add(edge[0]);
        }
        return new int[]{};
    }
    public static boolean isConnected(Map<Integer,List<Integer>> adjList,boolean[] visited,int src,int target){
        visited[src-1]=true;
        if(src==target){
            return true;
        }
        boolean isFound=false;
        List<Integer> neighbours=adjList.get(src)!=null?adjList.get(src):new ArrayList<>();
        for(int neighbour:neighbours){
            if(!visited[neighbour-1]){
                isFound=isFound || isConnected(adjList,visited,neighbour,target);
            }
        }
        return isFound;
    }
}
