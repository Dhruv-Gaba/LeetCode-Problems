class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        long badPairs=0;
        for(int i=0;i<nums.length;i++){
            long goodPairs=map.getOrDefault(i-nums[i],0);
            badPairs+=(i-goodPairs);
            map.put(i-nums[i],map.getOrDefault(i-nums[i],0)+1);
        }
        return badPairs;
    }
}
