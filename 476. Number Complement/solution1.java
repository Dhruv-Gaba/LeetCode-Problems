class Solution {
    public int findComplement(int num) {
        // APPROACH 1
        int temp=num;
        int count=0;
        while(temp!=0){
            temp=temp>>1;
            count++;
        }
        int mask=0;
        while(count>0){
            mask=mask<<1;
            mask=mask|1;
            count--;
        }
        return num^mask;
    }
}
