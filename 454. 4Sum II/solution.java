class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                map.put(nums1[i]+nums2[j],map.getOrDefault(nums1[i]+nums2[j],0)+1);
            }
        }
        int count=0;
        for(int x:nums3){
            for(int y:nums4){
                if(map.containsKey(-(x+y))){
                    count+=map.get(-(x+y));
                }
            }
        }
        return count;
    }
}
