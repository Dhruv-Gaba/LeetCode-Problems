class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return fairPairs(nums,upper+1)-fairPairs(nums,lower);
    }
    private long fairPairs(int[] nums, int val){
        int left=0;
        int right=nums.length-1;
        long count=0;
        while(left<right){
            int sum=nums[left]+nums[right];
            if(sum<val){
                count+=right-left;
                left++;
            }
            else{
                right--;
            }
        }
        return count;
    }
}
