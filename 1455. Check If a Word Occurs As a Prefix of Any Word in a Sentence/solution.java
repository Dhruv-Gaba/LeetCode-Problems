import java.util.StringTokenizer;
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        StringTokenizer st=new StringTokenizer(sentence," ");
        int i=0;
        while(st.hasMoreTokens()){
            i++;
            if(st.nextToken().startsWith(searchWord)){
                return i;
            }
        }
        return -1;
    }
}
