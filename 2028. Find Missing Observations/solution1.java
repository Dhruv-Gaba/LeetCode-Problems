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
        int quotient=Nsum/n;
        int rem=Nsum%n;
        for(int i=0;i<n;i++){
            ans[i]=quotient+(i<rem?1:0);
        }
        return ans;
    }
}
