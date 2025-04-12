class Solution {
    class Info{
        int i;
        int j;
        int time;
        public Info(int i,int j,int time){
            this.i=i;
            this.j=j;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Info> q=new LinkedList<>();
        int current=0;
        int target=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    if(isValid(i+1,j,grid) && grid[i+1][j]==1){
                        q.add(new Info(i+1,j,1));
                    }
                    if(isValid(i-1,j,grid) && grid[i-1][j]==1){
                        q.add(new Info(i-1,j,1));
                    }
                    if(isValid(i,j+1,grid) && grid[i][j+1]==1){
                        q.add(new Info(i,j+1,1));
                    }
                    if(isValid(i,j-1,grid) && grid[i][j-1]==1){
                        q.add(new Info(i,j-1,1));
                    }
                    current++;
                }
                if(grid[i][j]!=0){
                    target++;
                }
            }
        }
        if(current==target){
            return 0;
        }
        while(!q.isEmpty()){
            Info curr=q.remove();
            if(grid[curr.i][curr.j]==1){
                grid[curr.i][curr.j]=2;
                current++;
                if(current==target){
                    return curr.time;
                }
                if(isValid(curr.i+1,curr.j,grid) && grid[curr.i+1][curr.j]==1){
                        q.add(new Info(curr.i+1,curr.j,curr.time+1));
                    }
                    if(isValid(curr.i-1,curr.j,grid) && grid[curr.i-1][curr.j]==1){
                        q.add(new Info(curr.i-1,curr.j,curr.time+1));
                    }
                    if(isValid(curr.i,curr.j+1,grid) && grid[curr.i][curr.j+1]==1){
                        q.add(new Info(curr.i,curr.j+1,curr.time+1));
                    }
                    if(isValid(curr.i,curr.j-1,grid) && grid[curr.i][curr.j-1]==1){
                        q.add(new Info(curr.i,curr.j-1,curr.time+1));
                    }
            }
        }
        return -1;
    }

    public boolean isValid(int i,int j,int[][] grid){
        return i>=0 && j>=0 && i<grid.length && j<grid[0].length;
    }
}
