class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int minLen=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int or=nums[i];
            if(or>=k){
                return 1;
            }
            for(int j=i+1;j<nums.length;j++){
                or=or|nums[j];
                if(or>=k){
                    minLen=Math.min(minLen,j-i+1);
                    break;
                }
            }
        }
        return minLen==Integer.MAX_VALUE?-1:minLen;
    }
}
