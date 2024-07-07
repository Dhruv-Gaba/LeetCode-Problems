class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drink=0,empty=0;
        while(numBottles>0){
            drink+=numBottles;
            empty=numBottles+empty;
            numBottles=0;
            while(empty>=numExchange){
                empty-=numExchange;
                numBottles++;
                numExchange++;
            }
        }
        return drink;
    }
}
