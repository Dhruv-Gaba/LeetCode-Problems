class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum[]=new long[nums.length];
        sum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i]=nums[i]+sum[i-1];
        }
        long totSum=sum[nums.length-1];
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(sum[i]>=totSum-sum[i]){
                count++;
            }
        }
        return count;
    }
}
