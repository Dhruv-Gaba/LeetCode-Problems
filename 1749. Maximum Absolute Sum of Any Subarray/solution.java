class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int lastPositiveSum=0;
        int lastNegativeSum=0;
        int sum=0;
        int maxSum=0;
        for(int x:nums){
            sum+=x;
            if(sum<0){
                lastNegativeSum=Math.min(lastNegativeSum,sum);
                maxSum=Math.max(maxSum,Math.abs(sum-lastPositiveSum));
            }else{
                lastPositiveSum=Math.max(lastPositiveSum,sum);
                maxSum=Math.max(maxSum,sum-lastNegativeSum);
            }
        }
        return maxSum;
    }
}
