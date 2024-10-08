class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack=new Stack<>();
        int unbalanced=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                stack.push('[');
            }
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    unbalanced++;
                }
            }
        }
        return (unbalanced+1);
    }
}
