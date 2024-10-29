class Solution {
    private int MAX_MOVES=0;
    public int maxMoves(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            MAX_MOVES=Math.max(MAX_MOVES,simulation(grid,i,0));
        }
        return MAX_MOVES;
    }
    private int simulation(int[][] grid,int row,int col){
        if(col==grid[0].length-1){
            MAX_MOVES=Math.max(MAX_MOVES,col);
            return MAX_MOVES;
        }
        if(row>0 && grid[row-1][col+1]>grid[row][col]){
            simulation(grid,row-1,col+1);
        }
        if(grid[row][col+1]>grid[row][col]){
            simulation(grid,row,col+1);
        }
        if(row<grid.length-1 && grid[row+1][col+1]>grid[row][col]){
            simulation(grid,row+1,col+1);
        }
        MAX_MOVES=Math.max(MAX_MOVES,col);
        return MAX_MOVES;
    }
}

