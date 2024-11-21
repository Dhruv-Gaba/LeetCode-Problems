class Solution {
    private static final int UNGUARDED=0;
    private static final int GUARDED=1;
    private static final int GUARD=2;
    private static final int WALL=3;
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] cells=new int[m][n];
        for(int guard[]:guards){
            cells[guard[0]][guard[1]]=GUARD;
        }
        for(int wall[]:walls){
            cells[wall[0]][wall[1]]=WALL;
        }
        for(int guard[]:guards){
            markGuarded(cells,guard[0],guard[1],m,n);
        }
        int count=0;
        for(int i=0;i<cells.length;i++){
            for(int j=0;j<cells[0].length;j++){
                if(cells[i][j]==UNGUARDED){
                    count++;
                }
            }
        }
        return count;
    }
    public void markGuarded(int cells[][],int row,int col,int m,int n){
        for(int i=row-1;i>=0;i--){
            if(cells[i][col]==WALL || cells[i][col]==GUARD){
                break;
            }
            cells[i][col]=GUARDED;
        }
        for(int i=row+1;i<m;i++){
            if(cells[i][col]==WALL || cells[i][col]==GUARD){
                break;
            }
            cells[i][col]=GUARDED;
        }
        for(int j=col-1;j>=0;j--){
            if(cells[row][j]==WALL || cells[row][j]==GUARD){
                break;
            }
            cells[row][j]=GUARDED;
        }
        for(int j=col+1;j<n;j++){
            if(cells[row][j]==WALL || cells[row][j]==GUARD){
                break;
            }
            cells[row][j]=GUARDED;
        }
    }
}
