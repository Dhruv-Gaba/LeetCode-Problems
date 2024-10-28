class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int maxLen=1;
        for(int i=0;i<nums.length;i++){
            int len=1;
            int sq=nums[i]*nums[i];
            int left=i+1;
            int right=nums.length-1;
            while(left<=right){
                int mid=(left+right)/2;
                if(nums[mid]==sq){
                    len++;
                    sq=nums[mid]*nums[mid];
                    left=mid+1;
                    right=nums.length-1;
                }
                else if(nums[mid]<sq){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
            maxLen=Math.max(maxLen,len);
        }
        return maxLen>1?maxLen:-1;
    }
}
