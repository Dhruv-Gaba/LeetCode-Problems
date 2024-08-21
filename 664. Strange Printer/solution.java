class Solution {
    public int strangePrinter(String s) {
        s=removeDuplicates(s);
        int n=s.length();
        Integer[][] memo=new Integer[n][n];
        return minimumTurns(0,n-1,s,memo);
    }

    private int minimumTurns(int start,int end,String s,Integer[][] memo){
        if(start>end){
            return 0;
        }
        if(memo[start][end]!=null){
            return memo[start][end];
        }
        int minTurns=1+minimumTurns(start+1,end,s,memo);
        for(int k=start+1;k<=end;k++){
            if(s.charAt(k)==s.charAt(start)){
                int turnWithMatches=minimumTurns(start,k-1,s,memo)+minimumTurns(k+1,end,s,memo);
                minTurns=Math.min(minTurns,turnWithMatches);
            }
        }
        memo[start][end]=minTurns;
        return minTurns;
    }

    private String removeDuplicates(String s){
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<s.length()){
            char c=s.charAt(i);
            sb.append(c);
            while(i<s.length() && s.charAt(i)==c){
                i++;
            }
        }
        return sb.toString();
    }
}
