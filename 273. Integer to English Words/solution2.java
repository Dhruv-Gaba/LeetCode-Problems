class Solution {
    private static final String[] ONES={"Zero ","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine "};
    private static final String[] TENS={"","","Twenty ","Thirty ","Forty ","Fifty ","Sixty ","Seventy ","Eighty ","Ninety "};
    private static final String[] TEENS={"Ten ","Eleven ","Twelve ","Thirteen ","Fourteen ","Fifteen ","Sixteen ","Seventeen ","Eighteen ","Nineteen "};

    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        StringBuilder sb=new StringBuilder();
        if(num>=1000000000){
            sb.append(numberToWords(num/1000000000));
            sb.append(" Billion ");
            num%=1000000000;
        }
        if(num>=1000000){
            sb.append(numberToWords(num/1000000));
            sb.append(" Million ");
            num%=1000000;
        }
        if(num>=1000){
            sb.append(numberToWords(num/1000));
            sb.append(" Thousand ");
            num%=1000;
        }
        if(num>=100){
            sb.append(ONES[num/100]);
            sb.append("Hundred ");
            num%=100;
        }
        if(num>=20){
            sb.append(TENS[num/10]);
            num%=10;
        }
        else if(num>=10){
            sb.append(TEENS[num-10]);
            num=0;
        }
        if(num>0){
            sb.append(ONES[num]);
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
}
