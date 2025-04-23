class Solution {
    public int removeStones(int[][] stones) {
        ArrayList<Integer> graph[]=new ArrayList[stones.length];
        for(int i=0;i<stones.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<stones.length;i++){
            for(int j=i+1;j<stones.length;j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        int count=0;
        boolean visited[]=new boolean[stones.length];
        for(int i=0;i<stones.length;i++){
            if(!visited[i]){
                dfs(i,graph,visited);
                count++;
            }
        }
        return stones.length-count;
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
