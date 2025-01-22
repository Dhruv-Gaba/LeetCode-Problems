class Solution {
    //MODIFYING THE SAME MATRIX
    public final int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] highestPeak(int[][] isWater) {
        int m=isWater.length;
        int n=isWater[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==1){
                    isWater[i][j]=0;
                    q.offer(new int[]{i,j});
                }
                else{
                    isWater[i][j]=-1;
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
                if(isValid(newX,newY,m,n) && isWater[newX][newY]==-1){
                    isWater[newX][newY]=1+isWater[x][y];
                    q.offer(new int[]{newX,newY});
                }
            }
        }
        return isWater;
    }
    public boolean isValid(int i,int j,int m,int n){
        return i>=0 && j>=0 && i<m && j<n;
    }
}
