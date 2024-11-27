class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int dist[]=new int[n];
        List<Integer>[] prev = new ArrayList[n]; 
        for (int i = 0; i < n; i++) { 
            prev[i] = new ArrayList<Integer>(); 
        }
        for(int i=0;i<n;i++){
            dist[i]=i;
            prev[i].add(i-1);
        }
        int ans[]=new int[queries.length];
        for(int j=0;j<queries.length;j++){
            int u=queries[j][0];
            int v=queries[j][1];
            prev[v].add(u);
            if(dist[u]+1<dist[v]){
                dist[v]=dist[u]+1;
            }
            for(int i=v+1;i<n;i++){
                for(int k=0;k<prev[i].size();k++){
                    dist[i]=Math.min(dist[i],dist[prev[i].get(k)]+1);
                }
            }
            ans[j]=dist[n-1];
        }
        return ans;
    }
}
