class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int maxCount=0;
        int cols=matrix[0].length;
        for(int[] currRow:matrix){
            int[] flipped=new int[cols];
            int count=0;
            for(int i=0;i<cols;i++){
                flipped[i]=1-currRow[i];
            }
            for(int[] row:matrix){
                if(Arrays.equals(row,currRow) || Arrays.equals(row,flipped)){
                    count++;
                }
            }
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }
}
