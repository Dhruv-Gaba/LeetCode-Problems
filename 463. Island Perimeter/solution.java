class Solution {
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int n1=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n1;j++){
                if(grid[i][j]==1){
                    if(i==0){
                        ans++;
                    }
                    if(i==n-1){
                        ans++;
                    }
                    if(i>0 && grid[i-1][j]==0){
                        ans++;
                    }
                    if(i<n-1 && grid[i+1][j]==0){
                        ans++;
                    }
                    if(j==0){
                        ans++;
                    }
                    if(j==n1-1){
                        ans++;
                    }
                    if(j>0 && grid[i][j-1]==0){
                        ans++;
                    }
                    if(j<n1-1 && grid[i][j+1]==0){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
