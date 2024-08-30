class Solution {
    private static final int INF=(int)2e9;
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        long currShortestDis=runDijkstra(edges,n,source,destination);
        if(currShortestDis<target)return new int[0][0];
        boolean matchesTarget=(currShortestDis==target);
        for(int[] edge:edges){
            if(edge[2]>0)continue;

            edge[2]=matchesTarget?INF:1;
            if(!matchesTarget){
                long newDistance=runDijkstra(edges,n,source,destination);
                if(newDistance<=target){
                    edge[2]+=target-newDistance;
                    matchesTarget=true;
                }
            }
        }
        return matchesTarget?edges:new int[0][0];
    }
    private long runDijkstra(int[][] edges, int n, int source,int destination){
        long[][] adjMatrix=new long[n][n];
        long[] minDistance=new long[n];
        boolean[] visited=new boolean[n];

        Arrays.fill(minDistance,INF);
        for(long[] row:adjMatrix){
            Arrays.fill(row,INF);
        }

        minDistance[source]=0;
        for(int[] edge:edges){
            if(edge[2]!=-1){
                adjMatrix[edge[0]][edge[1]]=edge[2];
                adjMatrix[edge[1]][edge[0]]=edge[2];
            }
        }

        for(int i=0;i<n;i++){
            int nearestUnvisitedNode=-1;
            for(int j=0;j<n;j++){
                if(!visited[j] && (nearestUnvisitedNode==-1 || minDistance[j]<minDistance[nearestUnvisitedNode])){
                    nearestUnvisitedNode=j;
                }
            }
            visited[nearestUnvisitedNode]=true;
            for(int v=0;v<n;v++){
                minDistance[v]=Math.min(minDistance[v],minDistance[nearestUnvisitedNode]+adjMatrix[nearestUnvisitedNode][v]);
            }
        }
        return minDistance[destination];
    }
}
