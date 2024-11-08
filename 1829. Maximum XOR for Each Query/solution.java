class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] prefix=new int[nums.length];
        int totalXOR=0;
        for(int x:nums){
            totalXOR=totalXOR^x;
        }
        prefix[0]=totalXOR;
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]^nums[nums.length-i];

        }

        int ans[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=prefix[i]^((int)Math.pow(2,maximumBit)-1);
        }
        return ans;
    }
}
