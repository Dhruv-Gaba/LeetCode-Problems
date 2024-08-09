class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isMagicSquare(int[][] grid,int i,int j){
        boolean seen[]=new boolean[10];
        for(int p=0;p<3;p++){
            for(int q=0;q<3;q++){
                if(grid[i+p][j+q]>9 || grid[i+p][j+q]<1)return false;
                if(seen[grid[i+p][j+q]])return false;
                seen[grid[i+p][j+q]]=true;
            }
        }
        int diag1 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
        int diag2 = grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j];

        if(diag1!=diag2)return false;

        int row1=grid[i][j]+grid[i][j+1]+grid[i][j+2];
        int row2=grid[i+1][j]+grid[i+1][j+1]+grid[i+1][j+2];
        int row3=grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+2];
        if(row1!=diag1 || row2!=diag1 || row3!=diag1)return false;

        int col1=grid[i][j]+grid[i+1][j]+grid[i+2][j];
        int col2=grid[i][j+1]+grid[i+1][j+1]+grid[i+2][j+1];
        int col3=grid[i][j+2]+grid[i+1][j+2]+grid[i+2][j+2];

        if(col1!=diag1 || col2!=diag1 || col3!=diag1)return false;

        return true;
    }
}
