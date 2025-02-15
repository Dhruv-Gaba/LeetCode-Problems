class Solution {
    public int punishmentNumber(int n) {
        int ans=0;
        for(int i=1;i<=n;i++){
            int sq=i*i;
            String str=Integer.toString(sq);
            int[][] memo=new int[str.length()][i+1];
            for(int row[]:memo){
                Arrays.fill(row,-1);
            }
            if(findPartitions(0,i,0,str,memo)){
                ans+=sq;
            }
        }
        return ans;
    }
    public boolean findPartitions(int startIdx,int target,int sum,String str,int[][] memo){
        if(startIdx==str.length()){
            return target==sum;
        }
        if(sum>target){
            return false;
        }
        if(memo[startIdx][sum]!=-1){
            return memo[startIdx][sum]==1;
        }
        boolean found=false;
        for(int i=startIdx;i<str.length();i++){
            String currStr=str.substring(startIdx,i+1);
            int currSum=Integer.parseInt(currStr);
            found=found||findPartitions(i+1,target,sum+currSum,str,memo);
            if(found){
                memo[startIdx][sum]=1;
                return true;
            }
        }
        memo[startIdx][sum]=0;
        return false;
    }
}
