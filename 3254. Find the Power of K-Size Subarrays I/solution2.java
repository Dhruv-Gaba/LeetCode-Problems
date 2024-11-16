class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int[] result=new int[nums.length-k+1];
        for(int i=0;i<nums.length-k+1;i++){
            for(int j=i;j<i+k;j++){
                if(j!=i && nums[j]!=nums[j-1]+1){
                    result[i]=-1;
                }
            }
            if(result[i]!=-1){
                result[i]=nums[i+k-1];
            }
        }
        return result;
    }
}
