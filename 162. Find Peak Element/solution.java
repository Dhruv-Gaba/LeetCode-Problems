class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(mid==0){
                if(nums[mid]>nums[mid+1]){
                    return mid;
                }
                else{
                    left=mid+1;
                    continue;
                }
            }
            if(mid==nums.length-1){
                if(nums[mid]>nums[mid-1]){
                    return mid;
                }else{
                    right=mid-1;
                    continue;
                }
            }
            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]){
                return mid;
            }
            if(nums[mid-1]>nums[mid+1]){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return -1;
    }
}
