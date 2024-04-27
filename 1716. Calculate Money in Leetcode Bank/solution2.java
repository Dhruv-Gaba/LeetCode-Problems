class Solution {
    public int totalMoney(int n) {
        int start=1;
        int incr=0;
        int total=0;
        for(int i=1;i<=n;i++){
            total+=(start+incr);
            incr++;
            if(i%7==0){
                start++;
                incr=0;
            }
        }
        return total;
    }
}
