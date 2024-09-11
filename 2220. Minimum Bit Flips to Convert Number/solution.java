class Solution {
    public int minBitFlips(int start, int goal) {
        int count=0;
        while(goal>0){
            if((goal&1)!=(start&1)){
                count++;
            }
            start=start>>1;
            goal=goal>>1;
        }
        while(start>0){
            if((start&1)==1){
                count++;
            }
            start=start>>1;
        }
        return count;
    }
}
