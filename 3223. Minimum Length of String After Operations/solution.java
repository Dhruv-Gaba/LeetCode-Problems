class Solution {
    public int minimumLength(String s) {
        int[] count=new int[26];
        int ans=0;
        for(char c:s.toCharArray()){
            count[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(count[i]!=0){
                if(count[i]%2==0){
                    ans+=2;
                }
                else{
                    ans++;
                }
            }
        }
        return ans;
    }
}
