class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int edge[]:prerequisites){
            adj.computeIfAbsent(edge[0],k->new ArrayList<>()).add(edge[1]);
        }
        List<Boolean> ans=new ArrayList<>();
        for(int[] query:queries){
            boolean[] visited=new boolean[numCourses];
            ans.add(isPrerequisite(visited,adj,query[0],query[1]));
        }
        return ans;
    }
    public boolean isPrerequisite(boolean[] visited,Map<Integer,List<Integer>> adj,int src,int target){
        visited[src]=true;
        if(src==target){
            return true;
        }
        boolean ans=false;
        List<Integer> neighbours=adj.getOrDefault(src,new ArrayList<>());
        for(int neighbour:neighbours){
            if(!visited[neighbour]){
                ans=ans|isPrerequisite(visited,adj,neighbour,target);
            }
        }
        return ans;

    }
}
