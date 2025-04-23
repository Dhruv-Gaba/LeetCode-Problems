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
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Edge>[] graph=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i]=new ArrayList<>();
        }
        for(int time[]:times){
            graph[time[0]].add(new Edge(time[0],time[1],time[2]));
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{k,0});
        boolean visited[]=new boolean[n+1];
        while(!pq.isEmpty()){
            int[] curr=pq.remove();
            if(!visited[curr[0]]){
                visited[curr[0]]=true;
                for(int i=0;i<graph[curr[0]].size();i++){
                    Edge e=graph[curr[0]].get(i);
                    if(dist[e.src]+e.t<dist[e.dest]){
                        dist[e.dest]=dist[e.src]+e.t;
                        pq.add(new int[]{e.dest,dist[e.dest]});
                    }
                }
            }
        }
        int max=0;
        for(int i=1;i<n+1;i++){
            max=Math.max(max,dist[i]);
        }
        return max==Integer.MAX_VALUE?-1:max;
    }
}
