class Solution {
    public boolean canMakeSquare(char[][] grid) {
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                if(grid[i][j]==grid[i][j+1]){
                    if((i<2) && (grid[i+1][j]==grid[i][j] || grid[i+1][j+1]==grid[i][j])){
                        return true;
                    }
                    if((i>0) && (grid[i-1][j]==grid[i][j] || grid[i-1][j+1]==grid[i][j])){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
