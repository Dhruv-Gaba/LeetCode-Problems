class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){
            return -1;
        }
        int count=0;
        boolean visited[]=new boolean[n];
        ArrayList<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int connection[]:connections){
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(connection[0]);
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,graph,visited);
                count++;
            }
        }
        return count-1;
    }
    public void dfs(int curr,ArrayList<Integer>[] graph,boolean[] visited){
        visited[curr]=true;
        for(int neigh:graph[curr]){
            if(!visited[neigh]){
                dfs(neigh,graph,visited);
            }
        }
    }
}
