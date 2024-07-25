class Solution {
    public int[] sortArray(int[] nums) {
        //COUNTING SORT
        int max=nums[0];
        int min=nums[0];
        for(int x:nums){
            max=Math.max(max,x);
            min=Math.min(min,x);
        }
        int range=max-min+1;
        int count[]=new int[range];

        for(int x:nums){
            count[x-min]++;
        }
        int j=0;
        for(int i=0;i<count.length;i++){
            int freq=count[i];
            while(freq>0){
                nums[j++]=i+min;
                freq--;
            }
        }
        return nums;
    }
}
