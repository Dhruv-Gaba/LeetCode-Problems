class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> arr1Prefix=new HashSet<>();
        for(int x:arr1){
            while(!arr1Prefix.contains(x) && x>0){
                arr1Prefix.add(x);
                x/=10;
            }
        }
        int maxLen=0;
        for(int x:arr2){
            while(!arr1Prefix.contains(x) && x>0){
                x/=10;
            }
            if(x>0){
                maxLen=Math.max(maxLen,(int)Math.log10(x)+1);
            }
        }
        return maxLen;
    }
}
