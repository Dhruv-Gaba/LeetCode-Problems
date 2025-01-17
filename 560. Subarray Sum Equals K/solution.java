class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> prefixSum=new HashMap<>();
        int ans=0;
        prefixSum.put(0,1);
        int currSum=0;
        for(int num:nums){
            currSum+=num;
            if(prefixSum.containsKey(currSum-k)){
                ans+=prefixSum.get(currSum-k);
            }
            prefixSum.put(currSum,prefixSum.getOrDefault(currSum,0)+1);
        }
        return ans;
    }
}
