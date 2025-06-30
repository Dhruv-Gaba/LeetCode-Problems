class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int len=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]-nums[i]==1){
                len=Math.max(len,j-i+1);
            }
            while(nums[j]-nums[i]>1){
                i++;
            }
        }
        return len;
    }
}
