class FindSumPairs {
    int[] nums1;
    int[] nums2;
    Map<Integer,Integer> map;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1=nums1;
        this.nums2=nums2;
        map=new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],map.getOrDefault(nums2[i],0)+1);
        }
    }
    
    public void add(int index, int val) {
        map.put(nums2[index],map.get(nums2[index])-1);
        map.put(nums2[index]+val,map.getOrDefault(nums2[index]+val,0)+1);
        nums2[index]+=val;
    }
    
    public int count(int tot) {
        int count=0;
        for(int x:nums1){
            count+=map.getOrDefault(tot-x,0);
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
