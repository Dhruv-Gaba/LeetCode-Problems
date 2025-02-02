class Solution {
    public boolean check(int[] nums) {
        int countInversion=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[(i+1)%nums.length]){
                countInversion++;
            }
        }
        if(countInversion>1){
            return false;
        }
        return true;
    }
}
