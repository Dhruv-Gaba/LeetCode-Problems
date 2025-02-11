class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb=new StringBuilder(s);
        while(sb.indexOf(part)!=-1){
            int idx=sb.indexOf(part);
            sb.delete(idx,idx+part.length());
        }
        return sb.toString();
    }
}
