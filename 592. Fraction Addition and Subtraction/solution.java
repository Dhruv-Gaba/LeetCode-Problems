class Solution {
    public String fractionAddition(String expression) {
        int num=0;
        int denom=1;
        int i=0;
        while(i<expression.length()){
            int currNum=0;
            int currDenom=0;
            boolean isNegative=false;
            if(expression.charAt(i)=='-' || expression.charAt(i)=='+'){
                if(expression.charAt(i)=='-')isNegative=true;
                i++;
            }
            while(Character.isDigit(expression.charAt(i))){
                currNum=currNum*10+(expression.charAt(i)-'0');
                i++;
            }
            i++;
            if(isNegative)currNum*=-1;
            while(i<expression.length() && Character.isDigit(expression.charAt(i))){
                currDenom=currDenom*10+(expression.charAt(i)-'0');
                i++;
            }
            num=num*currDenom+currNum*denom;
            denom=denom*currDenom;
        }

        int gcd=Math.abs(findGCD(num,denom));
        num=num/gcd;
        denom=denom/gcd;
        return num+"/"+denom;
    }
    private int findGCD(int a,int b){
        if(a==0){
            return b;
        }
        return findGCD(b%a,a);
    }
}
