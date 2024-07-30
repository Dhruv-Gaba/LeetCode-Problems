class Solution {
    public int minimumDeletions(String s) {
        // APPROACH 2
        int[] dp=new int[s.length()+1];
        int bCount=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='a'){
                dp[i+1]=Math.min(dp[i]+1,bCount);
            }
            else{
                dp[i+1]=dp[i];
                bCount++;
            }
        }
        return dp[s.length()];
    }
}
