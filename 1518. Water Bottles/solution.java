class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drink=0,empty=0;
        while(numBottles>0){
            drink+=numBottles;
            empty=numBottles+empty;
            numBottles=empty/numExchange;
            empty=empty%numExchange;
        }
        return drink;
    }
}
