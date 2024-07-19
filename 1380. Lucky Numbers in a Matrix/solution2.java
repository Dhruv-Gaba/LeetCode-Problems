class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int[] max = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                max[i] = Math.max(max[i], matrix[j][i]);
            }
        }
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int col = -1;
        for (int i = 0; i < matrix.length; i++) {
            min = Integer.MAX_VALUE;
            col = -1;
            for (int j = 0; j < matrix[0].length; j++) {
                if (min > matrix[i][j]) {
                    min = matrix[i][j];
                    col = j;
                }
            }
            if (max[col] == min) {
                list.add(min);
            }

        }
        return list;
    }
}
