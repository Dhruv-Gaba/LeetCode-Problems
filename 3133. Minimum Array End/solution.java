class Solution {
    public long minEnd(int n, int x) {
        long lastNo=x;
        for(int i=1;i<n;i++){
            lastNo=(lastNo+1)|x;
        }
        return lastNo;
    }
}
