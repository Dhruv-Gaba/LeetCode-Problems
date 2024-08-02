class Solution {
    public int minSwaps(int[] nums) {
        int total=0;
        for(int x:nums){
            total+=x;
        }
        int sum=0;
        int swap=nums.length;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(i>=total){
                sum-=nums[i-total];
            }
            if(i>=total-1){
                swap=Math.min(swap,total-sum);
            }
        }
        for(int i=0;i<total-1;i++){
            sum+=nums[i]-nums[nums.length-total+i];
            swap=Math.min(swap,total-sum);
        }
        return swap;
    }
}
