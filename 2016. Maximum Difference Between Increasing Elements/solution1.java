class Solution {
    public int maximumDifference(int[] nums) {
        int n=nums.length;
        int curr_element=nums[0];
        int max_dif=0;
        for(int i=0;i<n;i++){
            curr_element=Math.min(curr_element,nums[i]);
            max_dif=Math.max()
        }
        if(max_dif==0){
            return -1;
        }
        return max_dif;
    }
}
