class Solution {
    public boolean isHappy(int n) {
        int num=0; 
        while(n!=1 && n!=4){
            num=0;
            while(n>0){
                int rem=n%10;
                num+=rem*rem;
                n/=10;
            }
            n=num;
        }
        return n==1;
    }
}
