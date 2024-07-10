class Solution {
    public int minOperations(String[] logs) {
        int steps=0;
        for(String s:logs){
            if(s.charAt(0)=='.'){
                if(s.charAt(1)=='.'){
                    steps=steps==0?0:steps-1;
                }
            }
            else{
                steps++;
            }
        }
        return steps;
    }
}
