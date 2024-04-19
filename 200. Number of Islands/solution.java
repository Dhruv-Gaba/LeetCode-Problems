class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0 || grid==null){
            return 0;
        }
        int num=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    num++;
                    dfs(grid,i,j);
                }
            }
        }
        return num;
    }
    public static void dfs(char[][] grid,int i,int j){
        grid[i][j]='0';    //marking the visited land
        if(i>0 && grid[i-1][j]=='1'){
            dfs(grid,i-1,j);    //top
        }
        if(i<grid.length-1 && grid[i+1][j]=='1'){
            dfs(grid,i+1,j);    //bottom
        }
        if(j>0 && grid[i][j-1]=='1'){
            dfs(grid,i,j-1);    //left
        }
        if(j<grid[0].length-1 && grid[i][j+1]=='1'){
            dfs(grid,i,j+1);    //right
        }
    }
}
