class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb=new StringBuilder(s);
        int i=0;
        int j=0;
        while(true){
            j=0;
            while(j<sb.length()){
                if(sb.charAt(j)== '('){
                    i=j;
                }
                if(sb.charAt(j)==')'){
                    break;
                }
                j++;
            }
            if(j==sb.length()){
                break;
            }
            sb.delete(i,i+1);
            j--;
            sb.delete(j,j+1);
            j--;
            StringBuilder sb1=new StringBuilder(sb.substring(i,j+1));
            sb.replace(i,j+1,sb1.reverse().toString());
        }
        return sb.toString();
    }
}
