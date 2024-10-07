class Solution {
    public int minLength(String s) {
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<sb.length();i++){
            if(i<sb.length()-1 && ((sb.charAt(i)=='A' && sb.charAt(i+1)=='B') || (sb.charAt(i)=='C' && sb.charAt(i+1)=='D'))){
                sb.delete(i,i+2);
                i=i==0?-1:i-2;
            }
        }
        return sb.length();
    }
}
