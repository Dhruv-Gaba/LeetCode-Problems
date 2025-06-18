class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans[][]=new int[nums.length/3][3];
        int x=0;
        for(int i=0;i<nums.length;i=i+3){
            if(nums[i+2]-nums[i]>k){
                return new int[][]{};
            }
        }
        for(int i=0;i<nums.length;i++){
            ans[x][0]=nums[i++];
            ans[x][1]=nums[i++];
            ans[x][2]=nums[i];
            x++;
        }
        return ans;
    }
}
