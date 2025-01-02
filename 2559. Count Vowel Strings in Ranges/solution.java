class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n=queries.length;
        int vowels[]=new int[words.length];
        for(int i=0;i<words.length;i++){
            char first=words[i].charAt(0);
            char last=words[i].charAt(words[i].length()-1);
            if(i==0){
                if(first=='a' || first=='e' || first=='o' || first=='u' || first=='i'){
                    if(last=='a' || last=='e' || last=='o' || last=='u' || last=='i'){
                        vowels[0]++;
                    }
                }
                continue;
            }
            if(first=='a' || first=='e' || first=='o' || first=='u' || first=='i'){
                if(last=='a' || last=='e' || last=='o' || last=='u' || last=='i'){
                    vowels[i]=vowels[i-1]+1;
                }
                else{
                    vowels[i]=vowels[i-1];
                }
            }
            else{
                vowels[i]=vowels[i-1];
            }
        }
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            ans[i]=l==0?vowels[r]:vowels[r]-vowels[l-1];
        }
        return ans;
    }
}
