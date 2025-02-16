class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res=new int[2*n-1];
        boolean used[]=new boolean[n+1];
        largestSequence(0,n,res,used);
        return res;
    }
    public boolean largestSequence(int pos,int n,int[] res,boolean[] used){
        if(pos==2*n-1){
            return true;
        }
        if(res[pos]!=0){
            return largestSequence(pos+1,n,res,used);
        }
        for(int i=n;i>=1;i--){
            if(used[i]){
                continue;
            }
            used[i]=true;
            res[pos]=i;
            if(i==1 && largestSequence(pos+1,n,res,used)){
                return true;
            }
            if(i>1 && (pos+i)<(2*n-1) && res[pos+i]==0){
                res[pos+i]=i;
                if(largestSequence(pos+1,n,res,used)){
                    return true;
                }
                res[pos+i]=0;
            }
            used[i]=false;
            res[pos]=0;
        }
        return false;
    }
}
