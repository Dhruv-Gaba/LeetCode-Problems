class Solution {
    class Info{
        int v;
        int cost;
        int stops;
        public Info(int v,int cost,int stops){
            this.v=v;
            this.cost=cost;
            this.stops=stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // ArrayList<int[]>[] graph=new ArrayList[n];
        // for(int i=0;i<n;i++){
        //     graph[i]=new ArrayList<>();
        // }
        // for(int flight[]:flights){
        //     graph[flight[0]].add(flight);
        // }
        // int cost=0;
        // PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        // pq.add(new int[]{-1,src,0});
        // int[] dist=new int[n];
        // Arrays.fill(dist,Integer.MAX_VALUE);
        // dist[src]=0;
        // int count=0;
        // while(!pq.isEmpty()){
        //     int[] curr=pq.remove();
        //     if(curr[0]>=k){
        //         break;
        //     }
        //         for(int i=0;i<graph[curr[1]].size();i++){
        //             int[] neighbour=graph[curr[1]].get(i);
        //             if(curr[2]+neighbour[2]<dist[neighbour[1]]){
        //                 dist[neighbour[1]]=curr[2]+neighbour[2];
        //                 pq.add(new int[]{curr[0]+1,neighbour[1],dist[neighbour[1]]});
        //             }
        //         }
        // }
        // return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];

        ArrayList<int[]>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int flight[]:flights){
            graph[flight[0]].add(flight);
        }

        Queue<Info> q=new LinkedList<>();
        q.add(new Info(src,0,0));
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr.stops>k){
                break;
            }
            for(int i=0;i<graph[curr.v].size();i++){
                int[] edge=graph[curr.v].get(i);
                if(curr.cost+edge[2]<dist[edge[1]]){
                    dist[edge[1]]=curr.cost+edge[2];
                    q.add(new Info(edge[1],dist[edge[1]],curr.stops+1));
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}
