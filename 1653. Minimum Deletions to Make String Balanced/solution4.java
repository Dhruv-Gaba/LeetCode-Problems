class Solution {
    public int minimumDeletions(String s) {
        //APPROACH 4
        int aCount=0;
        int bCount=0;
        int output=Integer.MAX_VALUE;
        char[] letters=s.toCharArray();
        for(char ch:letters){
            aCount+=('b' - ch);
        }
        for(char ch:letters){
            output=Math.min(output,aCount+bCount);
            aCount-=('b' - ch);
            bCount+=(ch - 'a');
        }
        output=Math.min(output,aCount+bCount);
        return output;
    }
}
