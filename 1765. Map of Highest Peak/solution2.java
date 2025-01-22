class Solution {
    //NOT MODIFYING THE INPUT MATRIX
    public final int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] highestPeak(int[][] isWater) {
        int m=isWater.length;
        int n=isWater[0].length;
        int[][] height=new int[m][n];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==1){
                    height[i][j]=0;
                    q.offer(new int[]{i,j});
                }
                else{
                    height[i][j]=-1;
                }
            }
        }
        while(!q.isEmpty()){
            int idx[]=q.poll();
            int x=idx[0];
            int y=idx[1];
            for(int direction[]:directions){
                int newX=x+direction[0];
                int newY=y+direction[1];
                if(isValid(newX,newY,m,n) && height[newX][newY]==-1){
                    height[newX][newY]=1+height[x][y];
                    q.offer(new int[]{newX,newY});
                }
            }
        }
        return height;
    }
    public boolean isValid(int i,int j,int m,int n){
        return i>=0 && j>=0 && i<m && j<n;
    }
}
