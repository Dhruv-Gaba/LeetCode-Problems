class Solution {
    class Pair{
        int v;
        int cost;
        public Pair(int v,int cost){
            this.v=v;
            this.cost=cost;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        ArrayList<Pair>[] graph=new ArrayList[points.length];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<points.length;i++){
            for(int j=0;j<points.length;j++){
                graph[i].add(new Pair(j,Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1])));
            }
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Pair(0,0));
        int minCost=0;
        boolean[] visited=new boolean[points.length];
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!visited[curr.v]){
                visited[curr.v]=true;
                minCost+=curr.cost;
                for(int i=0;i<graph[curr.v].size();i++){
                    if(!visited[graph[curr.v].get(i).v])pq.add(graph[curr.v].get(i));
                }
            }
        }
        return minCost;
    }
}
