class Solution {
    public int minSteps(int n) {
        if(n==1){
            return 0;
        }
        return count(1,1,n,1);
    }
    private int count(int c,int copied, int n,int steps){
        if(c==n){
            return steps;
        }
        else if(c>n){
            return Integer.MAX_VALUE;
        }

        int c1=count(c+copied,copied,n,steps+1);
        copied=c;
        int c2=count(c+copied,copied,n,steps+2);
        return Math.min(c1,c2);
    }
}
