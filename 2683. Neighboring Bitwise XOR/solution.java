class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int expVal=derived[0];
        int n=derived.length;
        for(int i=0;i<n;i++){
            if(derived[i]==1){
                expVal=expVal==1?0:1;
            }
            if(i==n-1){
                return expVal==derived[0];
            }
        }
        return false;
    }
}
