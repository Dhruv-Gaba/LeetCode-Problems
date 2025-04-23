class Solution {
    final int directions[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        boolean visited[][] = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, 1 });
        visited[0][0]=true;
        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int i = curr[0];
            int j = curr[1];
            int path = curr[2];
            if (i == n - 1 && j == n - 1) {
                return path;
            }
            for (int direction[] : directions) {
                int x = direction[0];
                int y = direction[1];
                if (isValid(i + x, j + y, n) && !visited[i + x][j + y] && grid[i + x][j + y] == 0) {
                    visited[i + x][j + y] = true;
                    q.add(new int[] { i + x, j + y, path + 1 });
                }
            }
        }
        return -1;
    }

    public boolean isValid(int i, int j, int n) {
        return i >= 0 && j >= 0 && i < n && j < n;
    }
}
