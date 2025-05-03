class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.length()==0){
            return 0;
        }
        boolean negative=false;
        if(s.charAt(0)=='-'){
            negative=true;
            s=s.substring(1,s.length());
        }else if(s.charAt(0)=='+'){
            s=s.substring(1,s.length());
        }
        int num=0;
        int upper=(int)(Math.pow(2,31)-1);
        int lower=(int)Math.pow(-2,31);
        for(int i=0;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i))){
                return negative?-1*num:num;
            }
            int digit=s.charAt(i)-'0';
            if((((long)num*(long)10)+(long)digit)>upper){
                return negative?lower:upper;
            }
            num=num*10;
            num=num+digit;
        }
        return negative?-1*num:num;
    }
}
