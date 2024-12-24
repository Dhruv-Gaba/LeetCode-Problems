class Solution {
    public String reverseWords(String s) {
        String words[]=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            String word=words[i].trim();
            sb.append(word);
            if(i!=0 && word!=""){
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
