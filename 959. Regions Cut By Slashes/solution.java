class Solution {
    private static final int[][] DIRECTIONS={{0,1},{0,-1},{1,0},{-1,0}};
    public int regionsBySlashes(String[] grid) {
        int gridSize=grid.length;
        int[][] expandedGrid=new int[gridSize*3][gridSize*3];
        for(int i=0;i<gridSize;i++){
            for(int j=0;j<gridSize;j++){
                int baseRow=i*3;
                int baseCol=j*3;
                if(grid[i].charAt(j)=='\\'){
                    expandedGrid[baseRow][baseCol]=1;
                    expandedGrid[baseRow+1][baseCol+1]=1;
                    expandedGrid[baseRow+2][baseCol+2]=1;
                }
                else if(grid[i].charAt(j)=='/'){
                    expandedGrid[baseRow][baseCol+2]=1;
                    expandedGrid[baseRow+1][baseCol+1]=1;
                    expandedGrid[baseRow+2][baseCol]=1;
                }
            }
        }
        int regionCount=0;
        for(int i=0;i<gridSize*3;i++){
            for(int j=0;j<gridSize*3;j++){
                if(expandedGrid[i][j]==0){
                    floodFill(expandedGrid,i,j);
                    regionCount++;
                }
            }
        }
        return regionCount;
    }
    private void floodFill(int[][] expandedGrid, int row,int col){
        Queue<int[]> queue=new LinkedList<>();
        expandedGrid[row][col]=1;
        queue.add(new int[] {row,col});
        while(!queue.isEmpty()){
            int[] currentCell=queue.poll();
            for(int[] direction:DIRECTIONS){
                int newRow=currentCell[0]+direction[0];
                int newCol=currentCell[1]+direction[1];
                if(isValidCell(expandedGrid,newRow,newCol)){
                    expandedGrid[newRow][newCol]=1;
                    queue.add(new int[] {newRow,newCol});
                }
            }
        }
    }
    private boolean isValidCell(int[][] expandedGrid,int row,int col){
        int size=expandedGrid.length;
        return (row>=0 && col>=0 && row<size && col<size && expandedGrid[row][col]==0);
    }
}
