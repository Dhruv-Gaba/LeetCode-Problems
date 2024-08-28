class Solution {
    final static int[][] DIRECTIONS={{0,1},{0,-1},{1,0},{-1,0}};
    private boolean isLandCell(int i,int j,int[][] grid){
        return grid[i][j]==1;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count=0;
        boolean visited[][]=new boolean[grid2.length][grid2[0].length];
        for(int i=0;i<grid2.length;i++){
            for(int j=0;j<grid2[0].length;j++){
                if(isLandCell(i,j,grid2) && !visited[i][j]){
                    visited[i][j]=true;
                    if(isSubIsland(grid1,grid2,i,j,visited)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    private boolean isSubIsland(int[][] grid1,int[][] grid2,int i,int j,boolean[][] visited){
        boolean ans=true;
        if(!isLandCell(i,j,grid1)){
            ans=false;
        }

        for(int[] direction:DIRECTIONS){
            int nexti=i+direction[0];
            int nextj=j+direction[1];

            if(nexti>=0 && nextj>=0 && nexti<grid2.length && nextj<grid2[0].length && !visited[nexti][nextj] && isLandCell(nexti,nextj,grid2)){
                visited[nexti][nextj]=true;
                boolean nextAns=isSubIsland(grid1,grid2,nexti,nextj,visited);
                ans=ans && nextAns;
            }
        }
        return ans;
    }
}
