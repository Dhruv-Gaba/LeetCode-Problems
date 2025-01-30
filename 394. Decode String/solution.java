class Solution {
    public String decodeString(String s) {
        Stack<String> stack=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch==']'){
                StringBuilder sb=new StringBuilder();
                while(!stack.peek().equals("[")){
                    sb.insert(0,stack.pop());
                }
                stack.pop();
                String str=sb.toString().repeat(extractNum(stack));
                stack.push(str);
            }
            else{
                stack.push(Character.toString(ch));
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }
    public int extractNum(Stack<String> stack){
        boolean isNum=true;
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty() && isNum){
            try{
                int num=Integer.parseInt(stack.peek());
                isNum=true;
            }catch(NumberFormatException e){
                isNum=false;
            }
            if(isNum){
                sb.insert(0,stack.pop());
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
