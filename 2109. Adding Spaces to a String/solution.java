class Solution {
    public String addSpaces(String s, int[] spaces) {
        int j=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(j<spaces.length && i==spaces[j]){
                sb.append(" ");
                j++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
