class Solution {
    public int trapRainWater(int[][] heightMap) {
        int dRow[]={0,0,-1,1};
        int dCol[]={-1,1,0,0};

        int numRows=heightMap.length;
        int numCols=heightMap[0].length;
        boolean visited[][]=new boolean[numRows][numCols];

        PriorityQueue<Cell> boundary=new PriorityQueue<>();

        for(int i=0;i<numRows;i++){
            boundary.offer(new Cell(heightMap[i][0],i,0));
            boundary.offer(new Cell(heightMap[i][numCols-1],i,numCols-1));
            visited[i][0]=visited[i][numCols-1]=true;
        }

        for(int i=0;i<numCols;i++){
            boundary.offer(new Cell(heightMap[0][i],0,i));
            boundary.offer(new Cell(heightMap[numRows-1][i],numRows-1,i));
            visited[0][i]=visited[numRows-1][i]=true;
        }

        int totalWater=0;
        while(!boundary.isEmpty()){
            Cell currentCell=boundary.poll();
            int minHeight=currentCell.height;
            int i=currentCell.i;
            int j=currentCell.j;

            for(int k=0;k<4;k++){
                int neighbourX=i+dRow[k];
                int neighbourY=j+dCol[k]; 
                if(isValid(neighbourX,neighbourY,numRows,numCols) && !visited[neighbourX][neighbourY]){
                    if(heightMap[neighbourX][neighbourY]<minHeight){
                        totalWater+=(minHeight-heightMap[neighbourX][neighbourY]);
                    }
                    boundary.add(new Cell(Math.max(minHeight,heightMap[neighbourX][neighbourY]),neighbourX,neighbourY));
                    visited[neighbourX][neighbourY]=true;
                }
            }

        }
        return totalWater;
    }
    public boolean isValid(int i,int j,int numRows,int numCols){
        return i>=0 && j>=0 && i<numRows && j<numCols;
    }

    private static class Cell implements Comparable<Cell>{
        int height;
        int i;
        int j;

        public Cell(int height,int i,int j){
            this.height=height;
            this.i=i;
            this.j=j;
        }

        @Override
        public int compareTo(Cell other){
            return Integer.compare(this.height,other.height);
        }
    }
}
