class Solution {
    public int findComplement(int num) {
        //APPROACH 3
        int temp=num;
        int count=0;
        while(temp!=0){
            temp=temp>>1;
            count++;
        }
        return num^((int)(Math.pow(2,count)-1));
    }
}
