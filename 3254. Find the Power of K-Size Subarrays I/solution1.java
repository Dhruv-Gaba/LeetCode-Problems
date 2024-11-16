class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int ans[]=new int[nums.length-k+1];
        for(int i=1;i<k;i++){
            if(nums[i]!=nums[i-1]+1){
                ans[0]=-1;
            }
        }
        ans[0]=ans[0]==-1?-1:nums[k-1];
        for(int j=1;j<nums.length-k+1;j++){
            if(ans[j-1]!=-1 && nums[j+k-1]==nums[j+k-2]+1){
                ans[j]=nums[j+k-1];
            }else{
                for(int p=j+1;p<j+k;p++){
                    if(nums[p]!=nums[p-1]+1){
                        ans[j]=-1;
                        break;
                    }
                }
                if(ans[j]!=-1){
                    ans[j]=nums[j+k-1];
                }
            }
        }
        return ans;
    }
}
