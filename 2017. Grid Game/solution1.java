class Solution {
    public long gridGame(int[][] grid) {
        int n=grid[0].length;
        long firstRowSum=0;
        for(int x:grid[0]){
            firstRowSum+=x;
        }
        long secondRowSum=0;
        long ans=Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            firstRowSum-=grid[0][i];
            long maxPoints=Math.max(firstRowSum,secondRowSum);
            ans=Math.min(ans,maxPoints);
            secondRowSum+=grid[1][i];
        }
        return ans;
    }
}
