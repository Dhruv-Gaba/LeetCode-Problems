class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> s=new Stack<>();
        int n=num.length();
        for(int i=0;i<n;i++){
            char a=num.charAt(i);
            while(!s.isEmpty() && s.peek()>a && k>0){
                s.pop();
                k--;
            }
            s.push(a);
        }
        while(k>0){
            s.pop();
            k--;
        }
        StringBuilder ans=new StringBuilder();
        while(!s.isEmpty()){
            ans.append(s.pop());
        }
        ans.reverse();
        while(ans.length()>0 && ans.charAt(0)=='0'){
            ans.delete(0,1);
        }
        return ans.length()==0?"0":ans.toString();
    }
}
