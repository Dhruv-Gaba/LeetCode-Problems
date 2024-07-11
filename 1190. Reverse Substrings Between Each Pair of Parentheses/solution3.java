class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<s.length()){
            char ch=s.charAt(i);
            if(ch=='('){
                stack.push(sb);
                sb=new StringBuilder();
            }
            else if(ch==')'){
                sb.reverse();
                if(!stack.isEmpty()){
                    stack.peek().append(sb);
                    sb=stack.pop();
                }
            }
            else{
                sb.append(ch);
            }
            i++;
        }
        return sb.toString();
    }
}
