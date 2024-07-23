class Solution {
    public int[] frequencySort(int[] nums) {
        //Approach 2
        HashMap<Integer,Integer> map=new HashMap<>();
        Integer[] sorted=new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            sorted[i]=nums[i];
        }
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        Arrays.sort(sorted,(lhs,rhs)->{
            int res=Integer.compare(map.get(lhs),map.get(rhs));
            if(res!=0){
                return res;
            }
            else{
                return rhs.compareTo(lhs);
            }
        });
        for(int i=0;i<nums.length;i++){
            nums[i]=sorted[i];
        }
        return nums;
    }
}
