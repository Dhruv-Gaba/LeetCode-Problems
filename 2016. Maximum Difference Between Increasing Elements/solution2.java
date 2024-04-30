class Solution {
    public int maximumDifference(int[] nums) {
        int n=nums.length;
        int max_dif=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                max_dif=Math.max(max_dif,nums[j]-nums[i]);
            }
        }
        if(max_dif==0){
            return -1;
        }
        return max_dif;
    }
}
