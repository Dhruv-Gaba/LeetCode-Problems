class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max=1;
        int c=1;
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]<nums[i+1]){
                c++;
            }else{
                max=Math.max(max,c);
                c=1;
            }
        }
        max=Math.max(max,c);
        c=1;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                c++;
            }else{
                max=Math.max(max,c);
                c=1;
            }
        }
        max=Math.max(max,c);
        return max;

    }
}
