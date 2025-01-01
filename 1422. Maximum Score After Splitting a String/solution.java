class Solution {
    public int maxScore(String s) {
        int one=0,zero=0;
        int ans=0;
        for(char x:s.toCharArray()){
            if(x=='1'){
                one++;
            }
        }
        for(int i=0;i<s.length()-1;i++){
            char x=s.charAt(i);
            if(x=='0'){
                zero++;
            }
            else{
                one--;
            }
            ans=Math.max(ans,one+zero);
        }
        return ans;
    }
}
