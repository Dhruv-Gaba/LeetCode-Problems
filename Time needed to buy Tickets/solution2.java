class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time=0;
        int target=tickets[k];
        for(int i=0;i<tickets.length;i++){
            if(tickets[i]>=target){
                if(i<=k){
                    time+=target;
                }
                else{
                    time+=target-1;
                }
            }
            else{
                time+=tickets[i];
            }
        }
        return time;
    }
}
