class Solution {
    public String[] divideString(String s, int k, char fill) {
        int len=s.length()/k;
        len=s.length()%k!=0?len+1:len;
        String[] ans=new String[len];
        int idx=0;
        for(int i=0;i<s.length();i=i+k){
            if(i+k>s.length()){
                ans[idx]=s.substring(i,s.length());
            }
            else{
                ans[idx++]=s.substring(i,i+k);
            }
        }
        if(ans[len-1].length()==k){
            return ans;
        }else{
            int diff=k-ans[len-1].length();
            ans[len-1]=ans[len-1]+String.valueOf(fill).repeat(diff);
        }
        return ans;
    }
}
