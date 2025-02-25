class Solution {
    int mod=(int)1e9+7;
    public int numOfSubarrays(int[] arr) {
        int evenCount=0;
        int oddCount=0;
        long sum=0;
        int ans=0;
        for(int x:arr){
            sum+=x;
            if(sum%2==0){
                ans=(ans+oddCount)%mod;
                evenCount++;
            }
            else{
                ans=(ans+evenCount+1)%mod;
                oddCount++;
            }
        }
        return ans;
    }
}
