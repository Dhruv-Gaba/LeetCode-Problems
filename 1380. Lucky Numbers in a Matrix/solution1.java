class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int col=findMin(matrix,i);

            if(maxInCol(matrix,matrix[i][col],col)){
                list.add(matrix[i][col]);
            }
        }
        return list;
    }

    public static int findMin(int[][] matrix,int i){
        int min=matrix[i][0];
        int col=0;
        for(int j=0;j<matrix[0].length;j++){
            if(min>matrix[i][j]){
                min=matrix[i][j];
                col=j;
            }
        }
        return col;
    }

    public static boolean maxInCol(int[][] matrix,int value,int j){
        for(int i=0;i<matrix.length;i++){
            if(value<matrix[i][j]){
                return false;
            }
        }
        return true;
    }
}
