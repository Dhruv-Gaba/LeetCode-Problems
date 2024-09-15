class Solution {
    public int findTheLongestSubstring(String s) {
        int charMap[]=new int[26];
        charMap['a'-'a']=1;
        charMap['e'-'a']=2;
        charMap['i'-'a']=4;
        charMap['o'-'a']=8;
        charMap['u'-'a']=16;
        int xor=0;
        int mp[]=new int[32];
        Arrays.fill(mp,-1);
        int longestSubstring=0;
        for(int i=0;i<s.length();i++){
            xor=xor^charMap[s.charAt(i)-'a'];
            if(mp[xor]==-1 && xor!=0){
                mp[xor]=i;
            }
            longestSubstring=Math.max(longestSubstring,i-mp[xor]);
        }
        return longestSubstring;
    }
}
