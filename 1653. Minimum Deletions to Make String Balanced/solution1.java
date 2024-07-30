class Solution {
    public int minimumDeletions(String s) {
        //APPROACH 1
        Stack<Character> stack=new Stack<>();
        int delCount=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!stack.isEmpty() && stack.peek()=='b' && ch=='a'){
                stack.pop();
                delCount++;
            }
            else{
                stack.push(ch);
            }
        }
        return delCount;
    }
}
