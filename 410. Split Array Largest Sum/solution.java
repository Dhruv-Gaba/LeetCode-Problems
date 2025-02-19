class Solution {
    public int splitArray(int[] nums, int k) {
        int left=0,right=0;
        for(int num:nums){
            right+=num;
            left=Math.max(left,num);
        }
        while(left<right){
            int mid=(left+right)/2;
            if(split(nums,k,mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    public boolean split(int[] nums,int k,int mid){
        int sum=0;
        int count=1;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]>mid){
                count++;
                sum=nums[i];
                if(count>k){
                    return false;
                }
            }else{
                sum+=nums[i];
            }
        }
        return true;
    }
}
