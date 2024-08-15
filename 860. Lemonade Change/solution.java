class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0;
        for(int x:bills){
            if(x==5){
                five++;
            }
            else if(x==10){
                if(five==0)return false;
                five--;
                ten++;
            }
            else if(x==20){
                if(five>=1 && ten>=1){
                    ten--;
                    five--;
                }
                else if(five>=3){
                    five-=3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
