class Solution {
    class Edge{
        int src;
        int dest;
        int t;
        public Edge(int s,int d,int t){
            this.src=s;
            this.dest=d;
            this.t=t;
        }
    }
    public int countPaths(int n, int[][] roads) {
        long MOD=1000000007;
        long time[]=new long[n];
        Arrays.fill(time,Long.MAX_VALUE);
        time[0]=0;
        ArrayList<Edge>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int road[]:roads){
            graph[road[0]].add(new Edge(road[0],road[1],road[2]));
            graph[road[1]].add(new Edge(road[1],road[0],road[2]));
        }
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        pq.add(new long[]{0,0});
        boolean visited[]=new boolean[n];
        long ways[]=new long[n];
        ways[0]=1;
        while(!pq.isEmpty()){
            long[] curr=pq.remove();
            int node=(int)curr[0];
            if(!visited[node]){
                visited[node]=true;.
                for(int i=0;i<graph[node].size();i++){
                    Edge e=graph[node].get(i);
                    if(time[e.src]+e.t<time[e.dest]){
                        time[e.dest]=time[e.src]+e.t;
                        ways[e.dest]=ways[e.src];
                        pq.add(new long[]{e.dest,time[e.dest]});
                    }
                    else if(time[e.src]+e.t==time[e.dest]){
                        ways[e.dest]=(ways[e.dest]+ways[e.src])%MOD;
                    }
                }
            }
        }
        return (int)(ways[n-1]%MOD);
    }
}
