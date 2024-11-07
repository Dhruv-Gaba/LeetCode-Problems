class Solution {
    public int largestCombination(int[] candidates) {
        int[] bitCount=new int[24];
        for(int num:candidates){
            for(int i=0;i<24;i++){
                bitCount[i]+=(num&1);
                num=num>>1;
            }
        }
        int max=0;
        for(int x:bitCount){
            max=Math.max(max,x);
        }
        return max;
    }
}
