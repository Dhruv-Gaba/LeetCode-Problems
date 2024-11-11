class Solution {
    public boolean primeSubOperation(int[] nums) {
        int prev=0;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                prev=0;
            }
            else{
                prev=nums[i-1];
            }
            int curr=nums[i]-1-prev;
            if(curr<0){
                return false;
            }
            while(curr>1 && !isPrime(curr)){
                curr--;
            }
            if(curr>1){
                nums[i]=nums[i]-curr;
            }
        }
        return true;
    }
    private boolean isPrime(int num){
        if(num==2){
            return true;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
