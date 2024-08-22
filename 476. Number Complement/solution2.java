class Solution {
    public int findComplement(int num) {
        //APPROACH 2
        int temp=num;
        int count=0;
        while(temp!=0){
            temp=temp>>1;
            count++;
        }
        return num^((1<<count)-1);
    }
}
