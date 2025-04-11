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
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Pair(0,0));
        int minCost=0;
        boolean[] visited=new boolean[points.length];
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!visited[curr.v]){
                visited[curr.v]=true;
                minCost+=curr.cost;
                for(int i=0;i<points.length;i++){
                    if(!visited[i]){
                        int dist=Math.abs(points[curr.v][0]-points[i][0])+Math.abs(points[curr.v][1]-points[i][1]);
                        pq.add(new Pair(i,dist));
                    }
                }
            }
        }
        return minCost;
    }
}
