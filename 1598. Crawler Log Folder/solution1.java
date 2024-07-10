class Solution {
    public int minOperations(String[] logs) {
        int steps=0;
        for(String s:logs){
            steps+=add(s,steps);
        }
        return steps;
    }
    public static int add(String s, int steps){
        return s.charAt(1)=='.'?steps==0?0:-1:s.charAt(0)=='.'?0:1;
    }
}
