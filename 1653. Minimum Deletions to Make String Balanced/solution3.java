class Solution {
    public int minimumDeletions(String s) {
        //APPROACH 3
        int minDel=0;
        int bCount=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='a'){
                minDel=Math.min(minDel+1,bCount);
            }
            else{
                bCount++;
            }
        }
        return minDel;
    }
}
