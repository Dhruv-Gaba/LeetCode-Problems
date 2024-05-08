class Solution {
    public String[] findRelativeRanks(int[] score) {
        int max=-1;
        for(int x:score){
            max=Math.max(max,x);
        }
        int count[]=new int[max+1];
        for(int i=0;i<score.length;i++){
            count[score[i]]=i+1;
        }
        int rank=0;
        String ans[]=new String[score.length];
        for(int i=max;i>=0;i--){
            if(count[i]>0){
                rank++;
                if(rank==1){
                    ans[count[i]-1]="Gold Medal";
                }
                else if(rank==2){
                    ans[count[i]-1]="Silver Medal";
                }
                else if(rank==3){
                    ans[count[i]-1]="Bronze Medal";
                }
                else{
                    ans[count[i]-1]=Integer.toString(rank);
                }
            }
        }
        return ans;
    }
}
