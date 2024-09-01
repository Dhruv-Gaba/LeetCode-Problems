class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n!=original.length){
            return new int[0][0];
        }
        int ans[][]=new int[m][n];
        int row=0;
        int col=0;
        for(int i=0;i<original.length;i++){
            ans[row][col++]=original[i];
            if(col==n){
                col=0;
                row++;
            }
        }
        return ans;
    }
}
