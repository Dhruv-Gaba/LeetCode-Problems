class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum=0;
        long currentSum=0;
        Set<Integer> set=new HashSet<>();
        int start=0;
        for(int end=0;end<nums.length;end++){
            while(set.contains(nums[end])){
                set.remove(nums[start]);
                currentSum-=nums[start];
                start++;
            }
            set.add(nums[end]);
            currentSum+=nums[end];
            if(end-start+1>k){
                set.remove(nums[start]);
                currentSum-=nums[start];
                start++;
            }
            if(end-start+1==k){
                maxSum=Math.max(maxSum,currentSum);
            }
        }
        return maxSum;
    }
}
