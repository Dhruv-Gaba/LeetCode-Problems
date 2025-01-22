class Solution {
    public final int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                }
                else{
                    mat[i][j]=-1;
                }
            }
        }

        while(!q.isEmpty()){
            int[] idx=q.poll();
            int x=idx[0];
            int y=idx[1];
            for(int direction[]:directions){
                int newX=x+direction[0];
                int newY=y+direction[1];
                if(isValid(newX,newY,m,n) && mat[newX][newY]==-1){
                    mat[newX][newY]=mat[x][y]+1;
                    q.offer(new int[]{newX,newY});
                }
            }
        }
        return mat;

    }
    public boolean isValid(int i,int j,int m,int n){
        return i>=0 && j>=0 && i<m && j<n;
    }
}
