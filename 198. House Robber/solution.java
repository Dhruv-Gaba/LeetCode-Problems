class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int max[]=new int[n];
        Arrays.fill(max,-1);
        return helper(nums,max,0,n);
    }
    public int helper(int[] nums,int[] max,int i,int n){
        if(i>=n){
            return 0;
        }
        if(max[i]!=-1){
            return max[i];
        }
        if(i==n-1){
            max[i]=nums[i];
            return max[i];
        }

        int way1=helper(nums,max,i+1,n);
        int way2=nums[i]+helper(nums,max,i+2,n);
        max[i]=Math.max(way1,way2);

        return max[i];
    }
}
