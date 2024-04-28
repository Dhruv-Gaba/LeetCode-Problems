class Solution {
    public boolean isAnagram(String s, String t) {
        int count[]=new int[26];
        if(s.length()!=t.length()){
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        return Arrays.equals(sChars, tChars);

    }
}
