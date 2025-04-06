class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int x:nums){
            list.add(x);
        }
        int count=0;
        while(!isSorted(list)){
            int minIdx=-1;
            int minSum=Integer.MAX_VALUE;
            for(int i=0;i<list.size()-1;i++){
                if(minSum>list.get(i)+list.get(i+1)){
                    minSum=list.get(i)+list.get(i+1);
                    minIdx=i;
                }
            }
            count++;
            list.add(minIdx,minSum);
            list.remove(minIdx+1);
            list.remove(minIdx+1);
        }
        return count;
    }
    public boolean isSorted(List<Integer> nums){
        for(int i=0;i<nums.size()-1;i++){
            if(nums.get(i)>nums.get(i+1)){
                return false;
            }
        }
        return true;
    }
}
