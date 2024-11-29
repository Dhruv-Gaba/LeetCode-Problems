class Solution {
    public int minimumTime(int[][] grid) {
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        if(grid[0][1]>1 && grid[1][0]>1){
            return -1;
        }
        int rows=grid.length;
        int cols=grid[0].length;
        boolean visited[][]=new boolean[rows][cols];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] current=pq.poll();
            int time=current[0];
            int row=current[1];
            int col=current[2];
            if(row==rows-1 && col==cols-1){
                return time;
            }
            if(visited[row][col]){
                continue;
            }
            visited[row][col]=true;
            for(int dir[]:directions){
                int newRow=row+dir[0];
                int newCol=col+dir[1];
                if(!isValid(newRow,newCol,grid,visited)){
                    continue;
                }
                int waitTime=((grid[newRow][newCol]-time)%2==0)?1:0;
                int newTime=Math.max(grid[newRow][newCol]+waitTime,time+1);
                pq.add(new int[]{newTime,newRow,newCol});
            }
        }
        return -1;
    }
    private boolean isValid(int i,int j,int[][] grid,boolean[][] visited){
        return i<grid.length && i>=0 && j>=0 && j<grid[0].length && !visited[i][j]?true:false;
    }
}
