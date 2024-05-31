class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int idx=-1;
        int ans[]=new int[2];
        if(nums[0]!=nums[1]){
            idx++;
            ans[idx]=nums[0];
        }
        if(nums[nums.length-1]!=nums[nums.length-2]){
            idx++;
            ans[idx]=nums[nums.length-1];
        }
        for(int i=0;i<nums.length;i++){
            if(idx==1){
                break;
            }
            if((i!=0 && i!=nums.length-1) && (nums[i]!=nums[i-1] && nums[i]!=nums[i+1])){
                idx++;
                ans[idx]=nums[i];
            }
        }
        return ans;
    }
}
