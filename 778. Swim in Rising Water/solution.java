class Solution {
    class Pair{
        int i;
        int j;
        public Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->grid[a.i][a.j]-grid[b.i][b.j]);
        pq.add(new Pair(0,0));
        int time=-1;
        boolean visited[][]=new boolean[n][n];
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            time=Math.max(time,grid[curr.i][curr.j]);
            if(curr.i==n-1 && curr.j==n-1){
                return time;
            }
            if(!visited[curr.i][curr.j]){
                visited[curr.i][curr.j]=true;
                for(int[] direction:directions){
                    int ni=curr.i+direction[0];
                    int nj=curr.j+direction[1];
                    if(isValid(ni,nj,n) && !visited[ni][nj]){
                        pq.add(new Pair(ni,nj));
                    }
                }

            }
        }
        return time;
    }
    public boolean isValid(int i,int j,int n){
        return i>=0 && i<n && j>=0 && j<n; 
    }
}
