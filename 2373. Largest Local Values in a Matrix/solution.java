class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n=grid.length;
        int max=0;
        int largest[][]=new int[n-2][n-2];
        for(int i=0;i<n-2;i++){
            for(int j=0;j<n-2;j++){
                for(int h=i;h<i+3;h++){
                    for(int k=j;k<j+3;k++){
                        max=Math.max(max,grid[h][k]);
                    }
                }
                largest[i][j]=max;
                max=0;
            }
        }
        return largest;
    }
}
