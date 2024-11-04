class Solution {
    public String compressedString(String word) {
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=word.length();i++){
            int count=1;
            char ch=word.charAt(i-1);
            while(i<word.length() && ch==word.charAt(i)){
                i++;
                count++;
            }
            while(count>9){
                sb.append("9");
                sb.append(ch);
                count-=9;
            }
            sb.append(count);
            sb.append(ch);
        }
        return sb.toString();
    }
}
