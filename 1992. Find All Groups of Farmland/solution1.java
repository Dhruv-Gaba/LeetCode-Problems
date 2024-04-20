class Solution {
    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> list=new ArrayList<int[]>();
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                if(land[i][j]==1){
                    int ans[]=findCoordinates(land,i,j);
                    list.add(ans);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }
    public static int[] findCoordinates(int[][] land, int i, int j){
        int[] ans=new int[4];
        ans[0]=i;
        ans[1]=j;
        int r=i;
        int c=j;
        while(r<land.length-1 && land[r+1][j]==1){
            r++;
        }
        while(c<land[0].length-1 && land[i][c+1]==1){
            c++;
        }
        ans[2]=r;
        ans[3]=c;
        for(int row=i;row<=r;row++){
            for(int col=j;col<=c;col++){
                land[row][col]=0;
            }
        }
        return ans;
    }
}
