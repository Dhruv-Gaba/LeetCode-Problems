class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly=new int[n];
        int i2=0,i3=0,i5=0;
        ugly[0]=1;
        int nextMultiple2=2;
        int nextMultiple3=3;
        int nextMultiple5=5;
        for(int i=1;i<n;i++){
            int minMultiple=Math.min(nextMultiple2,Math.min(nextMultiple3,nextMultiple5));
            ugly[i]=minMultiple;
            if(minMultiple==nextMultiple2){
                i2++;
                nextMultiple2=ugly[i2]*2;
            }
            if(minMultiple==nextMultiple3){
                i3++;
                nextMultiple3=ugly[i3]*3;
            }
            if(minMultiple==nextMultiple5){
                i5++;
                nextMultiple5=ugly[i5]*5;
            }
        }
        return ugly[n-1];
    }
}
