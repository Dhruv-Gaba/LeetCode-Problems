class Solution {
    public int subsetXORSum(int[] nums) {
        int result=0;
        for(int x:nums){
            result=result|x;
        }
        return result<<(nums.length-1);
    }
}
