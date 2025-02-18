class Solution {
    public int balancedStringSplit(String s) {
        int count=0;
        int p=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='L'){
                p++;
            }
            else{
                p--;
            }
            if(p==0){
                count++;
            }
        }
        return count;
    }
}
