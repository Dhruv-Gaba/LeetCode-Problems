class Solution {
    int directions[][]={{0,1},{0,-1},{1,0},{-1,0}};
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            if(grid[i][0]==1){
                makeZero(i,0,grid);
            }
            if(grid[i][n-1]==1){
                makeZero(i,n-1,grid);
            }
        }
        for(int i=0;i<n;i++){
            if(grid[0][i]==1){
                makeZero(0,i,grid);
            }
            if(grid[m-1][i]==1){
                makeZero(m-1,i,grid);
            }
        }
        int count=0;
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
    public void makeZero(int i,int j,int[][] grid){
        grid[i][j]=0;
        for(int direction[]:directions){
            int ni=i+direction[0];
            int nj=j+direction[1];
            if(isValid(ni,nj,grid) && grid[ni][nj]==1){
                makeZero(ni,nj,grid);
            }
        }
    }
    public boolean isValid(int i,int j,int[][] grid){
        return i>=0 && j>=0 && i<grid.length && j<grid[0].length;
    }
}
