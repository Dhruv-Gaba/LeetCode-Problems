class Solution {
    public double averageWaitingTime(int[][] customers) {
        int time=customers[0][0];
        double wait=0;
        for(int i=0;i<customers.length;i++){
            time=Math.max(time,customers[i][0])+customers[i][1];
            wait+=(time-customers[i][0]);
        }
        return wait/customers.length;
    }
}
