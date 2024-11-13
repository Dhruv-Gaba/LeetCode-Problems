class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int sum=nums[i]+nums[j];
                if(sum>=lower && sum<=upper){
                    count++;
                }
            }
        }
        return count;
    }
}
