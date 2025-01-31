class Solution {
    // final int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    // public int largestIsland(int[][] grid) {
    //     int n=grid.length;
    //     boolean visited[][];
    //     int ans=0;
    //     int count0=0;
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<n;j++){
    //             if(grid[i][j]==0){
    //                 count0++;
    //                 visited=new boolean[n][n];
    //                 grid[i][j]=1;
    //                 ans=Math.max(ans,check(grid,visited,i,j,n));
    //                 grid[i][j]=0;
    //             }
    //         }
    //     }
    //     return count0==0?n*n:ans;
    // }

    // public int check(int[][] grid, boolean visited[][], int i, int j, int n){
    //     if(grid[i][j]==0){
    //         return 0;
    //     }
    //     visited[i][j]=true;
    //     int count=1;
    //     for(int direction[]:directions){
    //         int x=i+direction[0];
    //         int y=j+direction[1];
    //         if(isValid(x,y,n) && !visited[x][y]){
    //             count+=check(grid,visited,x,y,n);
    //         }
    //     }
    //     return count;
    // }

    // boolean isValid(int i,int j,int n){
    //     return i>=0 && j>=0 && i<n && j<n;
    // }


    final int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        int islandId=2;
        Map<Integer,Integer> islandSizes=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int size=exploreIsland(grid,islandId,i,j,n);
                    islandSizes.put(islandId,size);
                    islandId++;
                }
            }
        }
        if(islandSizes.isEmpty()){
            return 1;
        }
        if(islandSizes.size()==1){
            islandId--;
            return islandSizes.get(islandId)==n*n?islandSizes.get(islandId):islandSizes.get(islandId)+1;
        }
        int ans=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    Set<Integer> set=new HashSet<>();
                    int currSize=1;
                    if(i<n-1 && grid[i+1][j]>1){
                        set.add(grid[i+1][j]);
                    }
                    if(i>0 && grid[i-1][j]>1){
                        set.add(grid[i-1][j]);
                    }
                    if(j<n-1 && grid[i][j+1]>1){
                        set.add(grid[i][j+1]);
                    }
                    if(j>0 && grid[i][j-1]>1){
                        set.add(grid[i][j-1]);
                    }
                    for(int id:set){
                        currSize+=islandSizes.get(id);
                    }
                    ans=Math.max(ans,currSize);
                }
            }
        }
        return ans;
    }

    public int exploreIsland(int[][] grid, int islandId,int i, int j, int n){
        if(grid[i][j]==0){
            return 0;
        }
        grid[i][j]=islandId;
        int count=1;
        for(int direction[]:directions){
            int x=i+direction[0];
            int y=j+direction[1];
            if(isValid(x,y,n) && grid[x][y]==1){
                count+=exploreIsland(grid,islandId,x,y,n);
            }
        }
        return count;
    }

    boolean isValid(int i,int j,int n){
        return i>=0 && j>=0 && i<n && j<n;
    }
}
