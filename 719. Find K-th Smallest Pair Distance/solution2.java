class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int x:nums){
            max=Math.max(max,x);
            min=Math.min(min,x);
        }
        int count[]=new int[max-min+1];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                int dif=Math.abs(nums[i]-nums[j]);
                count[dif]++;
            }
        }
        for(int i=0;i<count.length;i++){
            if(count[i]>=k){
                return i;
            }
            else{
                k-=count[i];
            }
        }
        return 0;
    }
}
