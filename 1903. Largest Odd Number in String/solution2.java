class Solution {
    public String largestOddNumber(String num) {
        String max="";
        for(int i=0;i<num.length();i++){
            if((num.charAt(i)-'0')%2!=0){
                max=num.substring(0,i+1);
            }
        }
        return max;
    }
}
