class Solution {
    private int[][] memo;
    public int maxMoves(int[][] grid) {
        memo=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            Arrays.fill(memo[i],-1);
        }
        int maxMoves=0;
        for(int i=0;i<grid.length;i++){
            maxMoves=Math.max(maxMoves,simulation(grid,i,0));
        }
        return maxMoves;
    }
    private int simulation(int[][] grid,int row,int col){
        if(col==grid[0].length-1){
            return 0;
        }
        if(memo[row][col]!=-1){
            return memo[row][col];
        }
        int maxMoves=0;
        if(row>0 && grid[row-1][col+1]>grid[row][col]){
            maxMoves=Math.max(maxMoves,1+simulation(grid,row-1,col+1));
        }
        if(grid[row][col+1]>grid[row][col]){
            maxMoves=Math.max(maxMoves,1+simulation(grid,row,col+1));

        }
        if(row<grid.length-1 && grid[row+1][col+1]>grid[row][col]){
            maxMoves=Math.max(maxMoves,1+simulation(grid,row+1,col+1));
        }
        memo[row][col]=maxMoves;
        return maxMoves;
    }
}


