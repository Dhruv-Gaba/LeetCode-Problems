class Solution {
    public int maxDistance(int[] colors) {
        int n=colors.length,i=0;
        if(colors[0]!=colors[n-1]){
            return n-1;
        }
        for(int j=n-1;j>=0;j--){
            if(colors[j-1]!=colors[j]){
                return j-1;
            }
            if(colors[i+1]!=colors[i]){
                return n-2-i;
            }
            i++;
        }
        return -1;
    }
}
