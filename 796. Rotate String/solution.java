class Solution {
    public boolean rotateString(String s, String goal) {
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==goal.charAt(0)){
                String end=s.substring(0,i);
                String start=s.substring(i,s.length());
                if(goal.equals(start+end)){
                    return true;
                }
            }
        }
        return false;
    }
}
