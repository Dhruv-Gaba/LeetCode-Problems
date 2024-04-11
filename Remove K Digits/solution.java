class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack=new Stack<>();
        for(char x:num.toCharArray()){
            while(!stack.isEmpty() && k>0 && stack.peek()>x){
                stack.pop();
                k--;
            }
            stack.push(x);
        }
        while(k>0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        while(sb.length()>0 && sb.charAt(0)=='0'){
            sb.delete(0,1);
        }
        return sb.length()>0?sb.toString():"0";
    }
}
