class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb=new StringBuilder();
        int i=0;
        for(i=0;i<word.length();i++){
            sb.append(word.charAt(i));
            if(word.charAt(i)==ch){
                sb.reverse();
                break;
            }
        }
        if(i==word.length()){
            return sb.toString();
        }
        sb.append(word.substring(i+1));
        return sb.toString();
    }
}
