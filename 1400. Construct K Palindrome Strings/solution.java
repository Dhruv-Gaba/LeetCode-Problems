class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length()<k){
            return false;
        }
        int count[]=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            count[ch-'a']++;
        }
        int odd=0;
        for(int i=0;i<26;i++){
            odd+=(count[i]%2);
        }
        if(odd>k){
            return false;
        }
        return true;
    }
}
