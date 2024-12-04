class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int j=0;
        for(int i=0;i<str1.length();i++){
            if(j==str2.length()){
                return true;
            }
            char ch1=str1.charAt(i);
            char ch2=str2.charAt(j);
            if(ch1==ch2 || (char)(ch1+1)==ch2 || (ch1=='z' && 'a'==ch2)){
                j++;
            }
        }
        return j==str2.length()?true:false;
    }
}
