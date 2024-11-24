class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;
        int count=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                sum+=Math.abs(matrix[i][j]);
                if(matrix[i][j]<0){
                    count++;
                }
                min=Math.min(min,Math.abs(matrix[i][j]));
            }
        }
        return count%2==0?sum:sum-(2*min);
    }
}
