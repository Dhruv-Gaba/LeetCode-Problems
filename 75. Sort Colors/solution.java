class Solution {
    public void sortColors(int[] nums) {
        int red=0,white=0,blue=0;
        for(int x:nums){
            if(x==0){
                red++;
            }
            else if(x==1){
                white++;
            }
            else{
                blue++;
            }
        }
        for(int i=0;i<red;i++){
            nums[i]=0;
        }
        for(int i=red;i<red+white;i++){
            nums[i]=1;
        }
        for(int i=red+white;i<nums.length;i++){
            nums[i]=2;
        }
    }
}
