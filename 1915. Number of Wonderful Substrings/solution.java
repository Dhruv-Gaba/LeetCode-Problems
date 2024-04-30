class Solution {
    public long wonderfulSubstrings(String word) {
        int count[]=new int[1024];
        int mask=0;
        count[mask]++;
        long ans=0;
        for(char x:word.toCharArray()){
            mask=mask^(1<<(x-'a'));
            ans+=count[mask];
            for(int i=0;i<10;i++){
                ans+=count[mask^(1<<i)];
            }
            count[mask]++;
        }
        return ans;
    }
}
