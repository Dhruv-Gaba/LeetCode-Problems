class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        if(n==1){
            return 0;
        }
        int target=n-1;
        int limit=nums[0];
        int newLimit=limit;
        int count=1;
        for(int i=0;i<=limit;i++){
            if(target<=limit){
                return count;
            }
            newLimit=Math.max(newLimit,i+nums[i]);
            if(i==limit){
                limit=newLimit;
                count++;
            }
        }
        return count;
    }
}
