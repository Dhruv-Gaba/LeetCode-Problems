class Solution {
    public int maxDepth(String s) {
        int max=0,count=0;
        for(char x:s.toCharArray()){
            if(x=='('){
                count++;
            }
            else if(x==')'){
                count--;
            }
            max=Math.max(max,count);
        }
        return max;
    }
}
