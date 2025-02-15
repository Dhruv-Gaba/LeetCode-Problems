class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        long sum=0;
        int j=0;
        int count=0;
        for(int i=1;i<=target;i++){
            if(sum>=target){
                break;
            }
            while(j<coins.length && coins[j]<=i){
                sum+=coins[j];
                j++;
            }
            if(sum<i){
                count++;
                sum+=i;
            }
        }
        return count;
    }
}
