class Solution {
    public boolean canJump(int[] nums) {
        int target=nums.length-1;
        int limit=nums[0];
        if(limit>=target){
            return true;
        }
        for(int i=1;i<=limit;i++){
            if(i+nums[i]>=target){
                return true;
            }
            limit=Math.max(limit,i+nums[i]);
        }
        return false;
    }
}
