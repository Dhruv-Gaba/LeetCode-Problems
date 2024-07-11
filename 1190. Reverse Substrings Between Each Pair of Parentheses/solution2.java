class Solution {
    int i=0;
    public String reverseParentheses(String s) {
        char[] arr=s.toCharArray();
        return helper(arr);
    }
    public String helper(char s[]){
        StringBuilder sb=new StringBuilder();
        while(i<s.length){
            if(s[i]=='('){
                i++;
                String str=helper(s);
                sb.append(str);
            }
            else if(s[i]==')'){
                i++;
                sb.reverse();
                return sb.toString();
            }
            else{
                sb.append(s[i]);
                i++;
            }
        }
        return sb.toString();
    }
}
