class Solution {
    public int countPalindromicSubsequence(String s) {
        int letters[]=new int[26];
        int unique[]=new int[26];
        int ans=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(letters[ch-'a']>0){
                continue;
            }
            letters[ch-'a']++;
            int j=s.length()-1;
            while(j>i && s.charAt(j)!=ch){
                j--;
            }
            if(j==i){
                continue;
            }
            int count=0;
            Arrays.fill(unique,0);
            for(int k=i+1;k<j;k++){
                char c=s.charAt(k);
                if(unique[c-'a']==0){
                    count++;
                }
                unique[c-'a']++;
            }
            ans+=count;
        }
        return ans;
    }
}
