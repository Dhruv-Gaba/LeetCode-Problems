class Solution {
    public int waysToSplitArray(int[] nums) {
        long totSum=0;
        for(int x:nums){
            totSum+=x;
        }
        int count=0;
        long currSum=0;
        for(int i=0;i<nums.length-1;i++){
            currSum+=nums[i];
            if(currSum>=totSum-currSum){
                count++;
            }
        }
        return count;
    }
}
