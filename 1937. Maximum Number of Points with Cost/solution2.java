class Solution {
    public long maxPoints(int[][] points) {
        int rows=points.length;
        int cols=points[0].length;
        long prevRow[]=new long[cols];
        for(int i=0;i<cols;i++){
            prevRow[i]=points[0][i];
        }
        for(int i=0;i<rows-1;i++){
            long[] leftMax=new long[cols];
            long[] rightMax=new long[cols];
            long[] currRow=new long[cols];

            leftMax[0]=prevRow[0];
            for(int j=1;j<cols;j++){
                leftMax[j]=Math.max(leftMax[j-1]-1,prevRow[j]);
            }
            rightMax[cols-1]=prevRow[cols-1];
            for(int j=cols-2;j>=0;j--){
                rightMax[j]=Math.max(rightMax[j+1]-1,prevRow[j]);
            }
            for(int j=0;j<cols;j++){
                currRow[j]=points[i+1][j] + Math.max(leftMax[j],rightMax[j]);
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
