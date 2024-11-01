class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb=new StringBuilder();
        int count=0;
        sb.append(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==sb.charAt(sb.length()-1)){
                count++;
            }
            else{
                count=0;
            }
            if(count<2){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
