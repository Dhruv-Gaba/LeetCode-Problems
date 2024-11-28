class Solution {
    private int directions[][]={{0,1},{0,-1},{1,0},{-1,0}};
    public int minimumObstacles(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] minObs=new int[m][n];
        for(int obs[]:minObs){
            Arrays.fill(obs,Integer.MAX_VALUE);
        }
        minObs[0][0]=grid[0][0];
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        q.add(new int[]{grid[0][0],0,0});
        while(!q.isEmpty()){
            int[] current=q.poll();
            int i=current[1];
            int j=current[2];
            if(i==m-1 && j==n-1){
                return current[0];
            }
            for(int direction[]:directions){
                int[] newNode=new int[3];
                newNode[1]=i+direction[0];
                newNode[2]=j+direction[1];
                if(!isValid(grid,newNode[1],newNode[2])){
                    continue;
                }
                newNode[0]=current[0]+grid[newNode[1]][newNode[2]];
                if(newNode[0]<minObs[newNode[1]][newNode[2]]){
                    minObs[newNode[1]][newNode[2]]=newNode[0];
                    q.add(newNode);
                }
            }
        }
        return -1;
    }
    private boolean isValid(int[][] grid,int i,int j){
        return i<grid.length && i>=0 && j>=0 && j<grid[0].length?true:false;
    }
}
