class Solution {
    public int findTheWinner(int n, int k) {
        int[] result=new int[n+1];
        int i=0;
        int tot=n;
        int count=0;
        while(tot>1){
            while(count<k){    
                i++; 
                if(i==n+1){   
                    i=1;
                }
                if(result[i]!=-1){
                    count++;
                }
            }
            result[i]=-1;
            count=0;
            tot--;   
        }
        for(int j=1;j<n+1;j++){
            if(result[j]!=-1){
                return j;
            }
        }
        return -1;
    }
}
