class Solution {
    public int minSteps(int n) {
        int ans=0;
        for(int i=2;i<=Math.sqrt(n);){
            if(n%i==0){
                ans+=i;
                n/=i;
            }
            else{
                i++;
            }
        }
        if(n!=1){
            ans+=n;
        }
        return ans;
    }
}
