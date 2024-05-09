class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int selection=0;
        int i=happiness.length-1;
        long ans=0;
        while(k>0){
            int h=happiness[i]>selection?happiness[i]-selection:0;
            ans+=h;
            selection++;
            k--;
            i--;
        }
        return ans;
    }
}
