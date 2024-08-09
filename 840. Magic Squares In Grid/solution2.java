class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int sum[] = new int[8];
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagicSquare(grid, sum, i, j)) {
                    count++;
                }
                Arrays.fill(sum, 0);
            }
        }
        return count;
    }

    private boolean isMagicSquare(int[][] grid, int[] sum, int i, int j) {
        HashSet<Integer> set = new HashSet<>();
        for (int p = 0; p < 3; p++) {
            for (int q = 0; q < 3; q++) {
                if (grid[i + p][j + q] > 9 || grid[i + p][j + q] == 0 || set.contains(grid[i + p][j + q])) {
                    return false;
                }
                set.add(grid[i + p][j + q]);
                sum[p] += grid[i + p][j + q];
                sum[3 + q] += grid[i + p][j + q];
            }
        }
        sum[6] = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
        sum[7] = grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j];
        for (int k = 0; k < 7; k++) {
            if (sum[k] != sum[k + 1]) {
                return false;
            }
        }
        return true;
    }
}
