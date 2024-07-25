class Solution {
    public int[] sortArray(int[] nums) {
        //COUNTING SORT

        int count[]=new int[2*50000+1];
        for(int x:nums){
            count[x+50000]++;
        }
        int j=0;
        for(int i=0;i<count.length;i++){
            if(j==nums.length){
                return nums;
            }
            while(count[i]!=0){
                nums[j]=i-50000;
                count[i]--;
                j++;
            }
        }
        return nums;
    }
}
