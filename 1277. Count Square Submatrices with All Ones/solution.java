class Solution {
    public int countSquares(int[][] matrix) {
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]>0){
                    subMatrix(i,j,matrix);
                }
            }
        }
        int sum=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                sum+=matrix[i][j];
            }
        }
        return sum;
    }
    private void subMatrix(int i,int j,int[][] matrix){
        if(matrix[i-1][j]>0 && matrix[i-1][j-1]>0 && matrix[i][j-1]>0){
            matrix[i][j]=Math.min(matrix[i-1][j],Math.min(matrix[i-1][j-1],matrix[i][j-1]))+1;
        }
    }
}


// 1 1 1 1
// 1 2 2 2
// 1 2 3 3
// 1 2 3 4

// 7+10+9+4=30
// 16+9+4+1=30

// 0 0 0
// 0 1 0
// 0 1 0
// 1 1 1 
// 1 2 0
