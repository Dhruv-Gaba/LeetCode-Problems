class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack=new Stack<>();
        int unbalanced=0;
        int open=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                open++;
            }
            else{
                if(open!=0){
                    open--;
                }
                else{
                    unbalanced++;
                }
            }
        }
        return (unbalanced+1)/2;
    }
}
