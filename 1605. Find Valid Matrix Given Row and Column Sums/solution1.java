class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ans=new int[rowSum.length][colSum.length];
        int i=0,j=0;
        while(i<rowSum.length && j<colSum.length){
            if(rowSum[i]<=colSum[j]){
                ans[i][j]=rowSum[i];
                colSum[j]-=ans[i][j];
                i++;
            }
            else{
                ans[i][j]=colSum[j];
                rowSum[i]-=ans[i][j];
                j++;
            }
        }
        return ans;
    }
}
