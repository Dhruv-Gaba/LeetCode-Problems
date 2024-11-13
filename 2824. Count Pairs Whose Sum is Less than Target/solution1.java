class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int count=0;
        Integer number[]=nums.toArray(new Integer[nums.size()]);
        for(int i=0;i<number.length;i++){
            for(int j=i+1;j<number.length;j++){
                if(number[i]+number[j]<target){
                    count++;
                }
            }
        }
        return count;
    }
}
