class Solution {
    final int[][] directions = {
            {0,1}, {0,-1}, {1,0}, {-1,0}
        };
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int minEffort=Integer.MAX_VALUE;
        int efforts[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(efforts[i],Integer.MAX_VALUE);
        }
        efforts[0][0]=0;
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[2]-b[2]);
        q.add(new int[]{0,0,0});
        while(!q.isEmpty()){
            int[] curr=q.remove();
            int i=curr[0];
            int j=curr[1];
            int effort=curr[2];
            if(i==m-1 && j==n-1){
                return effort;
            }
            for(int[] direction:directions){
                int x=direction[0];
                int y=direction[1];
                if(isValid(i+x,j+y,m,n)){
                    int newEffort=Math.max(effort,Math.abs(heights[i+x][j+y]-heights[i][j]));
                    if(newEffort<efforts[i+x][j+y]){
                        efforts[i+x][j+y]=newEffort;
                        q.add(new int[]{i+x,j+y,newEffort});
                    }
                }
            }
        }
        return -1;
    }
    public boolean isValid(int i,int j,int m,int n){
        return i>=0 && j>=0 && i<m && j<n;
    }
}
