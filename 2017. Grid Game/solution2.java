class Solution {
    public long gridGame(int[][] grid) {
        int n=grid[0].length;
        long[][] prefixSum=new long[2][n];
        prefixSum[0][0]=grid[0][0];
        prefixSum[1][0]=grid[1][0];
        for(int i=1;i<n;i++){
            prefixSum[0][i]=prefixSum[0][i-1]+grid[0][i];
            prefixSum[1][i]=prefixSum[1][i-1]+grid[1][i];
        }
        long ans=Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            long firstRowSum=prefixSum[0][n-1]-prefixSum[0][i];
            long secondRowSum=i>0?prefixSum[1][i-1]:0;
            long maxPoints=Math.max(firstRowSum,secondRowSum);
            ans=Math.min(ans,maxPoints);
        }
        return ans;
    }
}
