class Solution {
    public int minOperations(int[] nums, int k) {
        int xor=k;
        for(int i=0;i<nums.length;i++){
            xor=xor^nums[i];
        }
        int count=0;
        while(xor!=0){
            count+=xor&1;
            xor=xor>>1;
        }
        return count;
    }
}
