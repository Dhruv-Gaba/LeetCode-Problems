class Solution {
    public int maxProfit(int[] prices) {
        int[] max=new int[prices.length];
        max[prices.length-1]=prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            max[i]=Math.max(max[i+1],prices[i]);
        }
        int maxProfit=0;
        for(int i=0;i<prices.length-1;i++){
            maxProfit=Math.max(maxProfit,max[i+1]-prices[i]);
        }
        return maxProfit;
    }
}
