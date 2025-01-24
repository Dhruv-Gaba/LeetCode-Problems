class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int max[]=new int[n];
        Arrays.fill(max,-1);
        int way1=helper(nums,max,0,n-1);
        Arrays.fill(max,-1);
        int way2=helper(nums,max,1,n);
        return Math.max(way1,way2);
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
