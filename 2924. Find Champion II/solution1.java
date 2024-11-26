class Solution {
    public int findChampion(int n, int[][] edges) {
        int teams[]=new int[n];
        for(int edge[]:edges){
            teams[edge[1]]++;
        }
        int result=-1;
        for(int i=0;i<n;i++){
            if(teams[i]==0 && result!=-1){
                return -1;
            }
            else if(teams[i]==0){
                result=i;
            }
        }
        return result;
    }
}
