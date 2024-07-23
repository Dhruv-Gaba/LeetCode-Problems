class Solution {
    public int[] frequencySort(int[] nums) {
        //Approach 3
        HashMap<Integer,Integer> map=new HashMap<>();
        Integer[] sorted=new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            sorted[i]=nums[i];
        }
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        Arrays.sort(sorted,(lhs,rhs)->Integer.compare(map.get(lhs),map.get(rhs)));
        for(int i=0;i<nums.length;i++){
            nums[i]=sorted[i];
        }
        int temp;
        for(int i=0;i<nums.length-1;i++){
            if(map.get(nums[i])==map.get(nums[i+1]) && nums[i]<nums[i+1]){
                temp=nums[i];
                nums[i]=nums[i+1];
                nums[i+1]=temp;
                while(i>0 && map.get(nums[i])==map.get(nums[i-1]) && nums[i]>nums[i-1]){
                    temp=nums[i];
                    nums[i]=nums[i-1];
                    nums[i-1]=temp;
                    i--;
                }
            }
        }
        return nums;
    }
}
