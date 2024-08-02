class Solution {
    public int minSwaps(int[] nums) {
        int total=0;
        for(int x:nums){
            total+=x;
        }
        int zeros=0;
        for(int i=0;i<total;i++){
            if(nums[i]==0){
                zeros++;
            }
        }
        int swap=zeros;
        int j=0;
        for(int i=1;i<nums.length;i++){
            if(i+total<=nums.length){
                if(nums[i-1]==0){
                    zeros--;
                }
                if(nums[i+total-1]==0){
                    zeros++;
                }
            }
            else{
                if(nums[i-1]==0){
                    zeros--;
                }
                if(nums[i+total-nums.length-1]==0){
                    zeros++;
                }
            }
            swap=Math.min(swap,zeros);
        }
        return swap;
    }
}
