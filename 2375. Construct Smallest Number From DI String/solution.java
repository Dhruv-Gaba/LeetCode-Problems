class Solution {
    public String smallestNumber(String pattern) {
        //STACK APPROACH - GOOD O(N)
        StringBuilder sb=new StringBuilder();
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<=pattern.length();i++){
            s.push(i+1);
            if(i==pattern.length() || pattern.charAt(i)=='I'){
                while(!s.isEmpty()){
                    sb.append(s.pop());
                }
            }
        }
        return sb.toString();
    }
}
