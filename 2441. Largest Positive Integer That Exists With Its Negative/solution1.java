class Solution {
    public int findMaxK(int[] nums) {
        int check[]=new int[1001];
        int max=-1;
        for(int x:nums){
            int idx=x > 0 ? x : -x;
            if(check[idx]!=x){
                check[idx]+=x;
            }
            if(check[idx]==0){
                max = max > idx ? max : idx;
            }
        }
        return max;
    }
}
