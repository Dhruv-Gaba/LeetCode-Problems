class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[] rows=new int[m];
        int[] cols=new int[n];
        Map<Integer,int[]> map=new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map.put(mat[i][j],new int[]{i,j});
            }
        }
        for(int i=0;i<m*n;i++){
            int idx[]=map.get(arr[i]);
            rows[idx[0]]++;
            cols[idx[1]]++;
            if(rows[idx[0]]==n){
                return i;
            }
            if(cols[idx[1]]==m){
                return i;
            }
        }
        return -1;
    }
}
