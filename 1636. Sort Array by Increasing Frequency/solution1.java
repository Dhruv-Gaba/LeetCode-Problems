class Solution {
    public int[] frequencySort(int[] nums) {
        //aproach 1
        int count[]=new int[201];
        for(int x:nums){
            count[x+100]++;
        }

        for(int i=nums.length-1;i>=0;){
            int maxCount=0;
            int idx=-1;
            for(int j=0;j<201;j++){
                if(maxCount<count[j]){
                    maxCount=count[j];
                    idx=j;
                }
            }
            for(int j=0;j<maxCount;j++){
                nums[i]=idx-100;
                i--;
            }
            count[idx]=0;
        }
        return nums;
    }
}
