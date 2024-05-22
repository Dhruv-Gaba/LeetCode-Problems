class Solution {
    public int matrixScore(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]==0){
                for(int j=0;j<grid[0].length;j++){
                    grid[i][j]=1-grid[i][j];
                }
            }
        }
        for(int i=1;i<grid[0].length;i++){
            int c=count1s(i,grid);
            if(c<grid.length-c){
                for(int j=0;j<grid.length;j++){
                    grid[j][i]=1-grid[j][i];
                }
            }
        }
        int sum=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    sum+=1<<grid[0].length-1-j;
                }
            }
        }
        return sum;
    }
    public static int count1s(int j,int[][] grid){
        int count=0;
        for(int i=0;i<grid.length;i++){
            if(grid[i][j]==1){
                count++;
            }
        }
        return count;
    }
}
