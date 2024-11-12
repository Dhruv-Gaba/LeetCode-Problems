class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int ans[]=new int[queries.length];
        Arrays.sort(items,(a,b)->Integer.compare(a[0],b[0]));
        int max=0;
        for(int i=0;i<items.length;i++){
            max=Math.max(max,items[i][1]);
            items[i][1]=max;
        }
        for(int i=0;i<queries.length;i++){
            int q=queries[i];
            int start=0;
            int end=items.length-1;
            while(start<=end){
                int mid=(start+end)/2;
                if(items[mid][0]>q){
                    end=mid-1;
                }
                else{
                    ans[i]=Math.max(ans[i],items[mid][1]);
                    start=mid+1;
                }
            }
        }
        return ans;
    }
}
