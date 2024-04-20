class Solution {
    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> list=new ArrayList<int[]>();
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                if(land[i][j]==1){
                    ArrayList<Integer> ans=new ArrayList<>();
                    ans.add(i);
                    ans.add(j);
                    dfs(land,ans,i,j);
                    int arr[]=new int[4];
                    for(int k=0;k<4;k++){
                        arr[k]=ans.get(k);
                    }
                    list.add(arr);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }
    public static void dfs(int[][] land,ArrayList<Integer> ans, int i, int j){
        if(ans.size()==4){
            return;
        }
        land[i][j]=0;
        if(i<land.length-1 && land[i+1][j]==1){
            dfs(land,ans,i+1,j);
        }
        if(j<land[0].length-1 && land[i][j+1]==1){
            dfs(land,ans,i,j+1);
        }
        if(i+1>=land.length || land[i+1][j]==0){
            ans.add(i);
        }
        if(j+1>=land[0].length || land[i][j+1]==0){
            ans.add(j);
        }
    }
}
