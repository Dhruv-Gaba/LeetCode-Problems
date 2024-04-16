class Solution {
    public int reverse(int x) {
        long ans=0;
        int rem;
        while(x!=0){
            rem=x%10;
            ans=ans*10+rem;
            x=x/10;
        }
        if(ans==(int)ans){
            return (int)ans;
        }
        else{
            return 0;
        }
    }
}
