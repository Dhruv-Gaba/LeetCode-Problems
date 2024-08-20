class Solution {
    public int stoneGameII(int[] piles) {
        int[] suffixSum=Arrays.copyOf(piles,piles.length);
        for(int i=suffixSum.length-2;i>=0;i--){
            suffixSum[i]=suffixSum[i]+suffixSum[i+1];
        }
        return maxStones(suffixSum,1,0,new int[piles.length][piles.length]);
    }
    private int maxStones(int[] suffixSum,int M,int currIdx,int[][] memo){
        if(currIdx+2*M>=suffixSum.length){
            return suffixSum[currIdx];
        }
        if(memo[currIdx][M]>0){
            return memo[currIdx][M];
        }
        int res=Integer.MAX_VALUE;
        for(int i=1;i<=2*M;i++){
            res=Math.min(res,maxStones(suffixSum,Math.max(i,M),currIdx+i,memo));
        }
        memo[currIdx][M]=suffixSum[currIdx]-res;
        return memo[currIdx][M];
    }
}
//115 114 112 109 105 100        1,0
//115 114 112 109 105 100        1,1

