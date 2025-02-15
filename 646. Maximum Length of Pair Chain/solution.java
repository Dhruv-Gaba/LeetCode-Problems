class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->(a[1]-b[1]));
        int chainLen=1;
        int chainEnd=pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0]>chainEnd){
                chainLen++;
                chainEnd=pairs[i][1];
            }
        }
        return chainLen;
    }
}
