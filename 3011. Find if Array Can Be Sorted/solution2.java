class Solution {
    public boolean canSortArray(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>nums[j] && Integer.bitCount(nums[i])!=Integer.bitCount(nums[j])){
                    return false;
                }
            }
        }
        return true;
    }
}
