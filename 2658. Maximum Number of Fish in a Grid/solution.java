class Solution {
    final int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public int findMaxFish(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0 && !visited[i][j]){
                    ans=Math.max(ans,find(grid,visited,i,j,m,n));
                }
            }
        }
        return ans;
    }
    public int find(int[][] grid,boolean[][] visited,int i,int j,int m,int n){
        if(visited[i][j]){
            return 0;
        }
        visited[i][j]=true;
        int ans=grid[i][j];
        for(int[] direction:directions){
            int x=i+direction[0];
            int y=j+direction[1];
            if(isValid(x,y,m,n) && grid[x][y]!=0 && !visited[x][y]){
                ans+=find(grid,visited,x,y,m,n);
            }
        }
        return ans;
    }
    public boolean isValid(int i,int j,int m,int n){
        return i>=0 && i<m && j>=0 && j<n;
    }
}
