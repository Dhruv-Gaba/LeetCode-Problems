class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time=0;
        int i=0;
        while(tickets[k]>0){
            if(i==tickets.length){
                i=0;
            }
            if(tickets[i]==0){
                i++;
                continue;
            }
            tickets[i]--;
            time++;
            i++;
        }
        return time;
    }
}
