class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dis[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    dis[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < edges.length; i++) {
            if (edges[i][2] <= distanceThreshold) {
                dis[edges[i][0]][edges[i][1]] = edges[i][2];
                dis[edges[i][1]][edges[i][0]] = edges[i][2];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(dis[j][i]==Integer.MAX_VALUE){
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (dis[i][k] < Integer.MAX_VALUE && (dis[j][i] + dis[i][k]) < dis[j][k]) {
                        dis[j][k] = dis[j][i] + dis[i][k];
                    }
                }
            }
        }
        int minCount = n;
        int city = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (dis[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= minCount) {
                minCount = count;
                city = i;
            }
        }
        return city;
    }
}
