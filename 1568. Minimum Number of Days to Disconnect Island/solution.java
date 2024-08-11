class Solution {
    private static final int[][] DIRECTIONS={{0,1},{0,-1},{1,0},{-1,0}};
    public int minDays(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int initialIslandCount=countIsland(grid);

        if(initialIslandCount!=1){
            return 0;
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==0){
                    continue;
                }
                grid[i][j]=0;
                int newIslandCount=countIsland(grid);
                if(newIslandCount!=1){
                    return 1;
                }
                grid[i][j]=1;
            }
        }
        return 2;
    }
    private int countIsland(int[][] grid){
        int rows=grid.length;
        int cols=grid[0].length;
        boolean[][] visited=new boolean[rows][cols];
        int count=0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    exploreIsland(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }
    private void exploreIsland(int[][] grid,int row,int col,boolean[][] visited){
        visited[row][col]=true;
        for(int[] direction:DIRECTIONS){
            int newRow=row+direction[0];
            int newCol=col+direction[1];
            if(isValidLandCell(grid,newRow,newCol,visited)){
                exploreIsland(grid,newRow,newCol,visited);
            }
        }
    }
    private boolean isValidLandCell(int[][] grid,int i,int j,boolean[][] visited){
        int rows=grid.length;
        int cols=grid[0].length;
        return(i>=0 && i<rows && j>=0 && j<cols && !visited[i][j] && grid[i][j]==1);
    }
}
