class Solution {
    public long maxPoints(int[][] points) {
        int cols=points[0].length;
        long prevRow[]=new long[cols];
        long[] currRow=new long[cols];
        for(int[] row:points){
            long runningMax=0;
            for(int j=0;j<cols;j++){
                runningMax=Math.max(runningMax-1,prevRow[j]);
                currRow[j]=runningMax;
            }
            runningMax=0;
            for(int j=cols-1;j>=0;j--){
                runningMax=Math.max(runningMax-1,prevRow[j]);
                currRow[j]=Math.max(currRow[j],runningMax)+row[j];
            }
            prevRow=currRow;
        }
        long max=0;
        for(int i=0;i<cols;i++){
            max=Math.max(max,prevRow[i]);
        }
        return max;
    }
}
