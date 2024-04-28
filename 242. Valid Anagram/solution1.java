class Solution {
    public boolean isAnagram(String s, String t) {
        int count[]=new int[26];
        if(s.length()!=t.length()){
            return false;
        }
        for(char x:s.toCharArray()){
            count[x-'a']++;
        }
        for(char x:t.toCharArray()){
            if(count[x-'a']==0){
                return false;
            }
            count[x-'a']--;
        }
        return true;
    }
}
