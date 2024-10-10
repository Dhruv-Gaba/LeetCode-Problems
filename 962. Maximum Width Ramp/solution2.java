class Solution {
    public int maxWidthRamp(int[] nums) {
        int n=nums.length;
        Integer indices[]=new Integer[n];
        for(int i=0;i<n;i++){
            indices[i]=i;
        }
        Arrays.sort(indices,(i,j)->nums[i]!=nums[j]?nums[i]-nums[j]:i-j);
        int minIdx=n;
        int ramp=0;
        for(int i=0;i<indices.length;i++){
            ramp=Math.max(ramp,indices[i]-minIdx);
            minIdx=Math.min(minIdx,indices[i]);
        }
        return ramp;
    }
}
