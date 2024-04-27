class Solution {
    public int totalMoney(int n) {
        int money[]={1,3,6,10,15,21,28};
        int total=0;
        int incr=0;
        while(n>0){
            if(n<8){
                total+=money[n-1];
                total+=incr*n;
                n=0;
            }
            else{
                total+=money[6];
                total+=incr*7;
                incr++;
                n=n-7;
            }
        }
        return total;
    }
}
