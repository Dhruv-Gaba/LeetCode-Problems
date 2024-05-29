class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int count=nums.length;
        for(int i=0;i<nums.length;i++){
            if(count<=nums[i] ){
                if(i>=1){
                    if(count>nums[i-1]){
                        return count;
                    }
                }
                else{
                    return count;
                }
            }
            count--;
        }
        return -1;
    }
}
