class Solution {
    public int maxAscendingSum(int[] nums) {
        int max=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int sum=nums[i];
            while(i<n-1 && nums[i]<nums[i+1]){
                sum+=nums[i+1];
                i++;
            }
            max=Math.max(sum,max);
        }
        return max;
    }
}
