class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int Msum=0;
        for(int x:rolls){
            Msum+=x;
        }
        int count=n+rolls.length;
        int totSum=mean*count;
        int Nsum=totSum-Msum;
        if(Nsum<n || Nsum>n*6){
            return new int[0];
        }
        int ans[]=new int[n];
        Arrays.fill(ans,1);
        Nsum-=n;
        int i=0;
        while(Nsum>0){
            if(Nsum>=5){
                ans[i]+=5;
                Nsum-=5;
                i++;
            }
            else{
                ans[i]+=Nsum;
                Nsum=0;
                i++;
                break;
            }
        }
        return ans;
    }
}
