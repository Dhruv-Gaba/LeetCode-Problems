class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int minLen=Integer.MAX_VALUE;
        int bitCounts[]=new int[32];
        int windowStart=0,windowEnd=0;
        while(windowEnd<nums.length){
            updateBitCounts(bitCounts,nums[windowEnd],1);
            while(windowStart<=windowEnd && bitCountsToNumber(bitCounts)>=k){
                minLen=Math.min(minLen,windowEnd-windowStart+1);
                updateBitCounts(bitCounts,nums[windowStart],-1);
                windowStart++;
            }
            windowEnd++;
        }
        return minLen==Integer.MAX_VALUE?-1:minLen;
    }
    private void updateBitCounts(int[] bitCounts,int num,int delta){
        for(int i=0;i<32;i++){
            if(((num>>i)&1)!=0){
                bitCounts[i]+=delta;
            }
        }
    }
    private int bitCountsToNumber(int[] bitCounts){
        int result=0;
        for(int i=0;i<32;i++){
            if(bitCounts[i]!=0){
                result=result|(1<<i);
            }
        }
        return result;
    }
}
