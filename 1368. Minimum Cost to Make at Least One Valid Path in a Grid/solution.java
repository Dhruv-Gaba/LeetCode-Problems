class Solution {
    final int directions[][]={{0,1},{0,-1},{1,0},{-1,0}};
    public int minCost(int[][] grid) {
        int numRows=grid.length;
        int numCols=grid[0].length;
        int minCost[][]=new int[numRows][numCols];
        for(int i=0;i<numRows;i++){
            Arrays.fill(minCost[i],Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        minCost[0][0]=0;
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            for(int k=0;k<4;k++){
                int direction[]=directions[k];
                int i=curr[1]+direction[0];
                int j=curr[2]+direction[1];
                if(i<numRows && i>=0 && j<numCols && j>=0){
                    int addition=grid[curr[1]][curr[2]]==k+1?0:1;
                    int cost=curr[0]+addition;
                    if(minCost[i][j]>cost){
                        minCost[i][j]=cost;
                        pq.offer(new int[]{cost,i,j});
                    }
                }
            }
        }
        return minCost[numRows-1][numCols-1];
    }
}
