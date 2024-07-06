class Solution {
    public int passThePillow(int n, int time) {
        if(n==1){
            return 1;
        }
        int count=0;
        while(time>n-1){
            time=time-(n-1);
            count++;
        }
        if(count%2==0){
            return 1+time;
        }
        else{
            return n-time;
        }
    }
}
