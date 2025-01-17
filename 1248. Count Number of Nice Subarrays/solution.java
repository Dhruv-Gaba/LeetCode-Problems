class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]%2==0?0:1;
        }
        Map<Integer,Integer> map=new HashMap<>();
        int ans=0;
        map.put(0,1);
        int currSum=0;
        for(int num:nums){
            currSum+=num;
            if(map.containsKey(currSum-k)){
                ans+=map.get(currSum-k);
            }
            map.put(currSum,map.getOrDefault(currSum,0)+1);
        }
        return ans;
    }
}
