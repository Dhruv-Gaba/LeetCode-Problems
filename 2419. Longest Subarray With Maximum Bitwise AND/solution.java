class Solution {
    public int longestSubarray(int[] nums) {
        int key=0;
        for(int x:nums){
            key=Math.max(key,x);
        }
        int count=0;
        int max_Count=0;
        for(int x:nums){
            if(key==x){
                count++;
            }
            else{
                max_Count=Math.max(count,max_Count);
                count=0;
            }
        }
        max_Count=Math.max(count,max_Count);
        return max_Count;
    }
}
