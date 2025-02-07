class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int remainders[]=new int[60];
        int n=time.length;
        int count=0;
        for(int i=0;i<n;i++){
            count+=remainders[time[i]%60==0?0:60-(time[i]%60)];
            remainders[time[i]%60]++;
        }
        return count;
    }
}
