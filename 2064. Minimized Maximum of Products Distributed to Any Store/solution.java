class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left=0;
        int right=0;
        for(int x:quantities){
            right=Math.max(right,x);
        }
        while(left<right){
            int mid=(left+right)/2;
            if(canDistribute(mid,n,quantities)){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
    private boolean canDistribute(int k,int n,int[] quantities){
        int j=0;
        int m=quantities.length;
        int remaining=quantities[j];
        for(int i=0;i<n;i++){
            if(remaining<=k){
                j++;
                if(j==m){
                    return true;
                }
                remaining=quantities[j];
            }
            else{
                remaining-=k;
            }
        }
        return false;
    }
}
