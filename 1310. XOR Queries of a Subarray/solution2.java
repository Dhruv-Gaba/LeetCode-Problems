class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int ans[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int left=queries[i][0];
            int right=queries[i][1];
            ans[i]=arr[left];
            for(int j=left+1;j<=right;j++){
                ans[i]=ans[i]^arr[j];
            }
        }
        return ans;
    }
}
