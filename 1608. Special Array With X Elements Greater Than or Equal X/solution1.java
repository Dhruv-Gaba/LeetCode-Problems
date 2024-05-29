class Solution {
    public int specialArray(int[] nums) {
        int count[]=new int[nums.length+1];
        int bigNum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=nums.length){
                count[nums.length]++;
            }
            else{
                count[nums[i]]++;
            }
        }
        int big=0;
        for(int i=count.length-1;i>=0;i--){
            big+=count[i];
            if(i<big){
                return -1;
            }
            if(i==big){
                return i;
            }
        }
        return -1;
    }
}
