class Solution {
    public int minimumPushes(String word) {
        int count[]=new int[26];
        for(int i=0;i<word.length();i++){
            count[word.charAt(i)-'a']++;
        }
        Arrays.sort(count);
        int i=25;
        int ans=0;
        int push=1;
        int c=0;
        while(i>=0 && count[i]>0){
            ans+=count[i]*push;
            c++;
            if(c==8){
                c=0;
                push++;
            }
            i--;
        }
        return ans;
    }
}
