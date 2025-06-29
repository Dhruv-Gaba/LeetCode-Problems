class Solution {
    public int numSubseq(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        Arrays.sort(nums);
        int count=0;
        int MOD=1000000007;
        int[] pow=new int[nums.length];
        pow[0]=1;
        for(int k=1;k<nums.length;k++){
            pow[k]=(pow[k-1]*2)%MOD;
        }
        while(i<=j){
            while(j>=0 && nums[i]+nums[j]>target){
                j--;
            }
            if(i<=j){
                count=(count+pow[j-i])%MOD;
            }
            i++;
        }
        return count%MOD;
    }
}
