class Solution {
    public String intToRoman(int num) {
        StringBuilder sb=new StringBuilder();
        switch(num/1000){
            case 1:sb.append("M");
            break;
            case 2:sb.append("MM");
            break;
            case 3:sb.append("MMM");
            break;
        }
        num=num%1000;
        switch(num/100){
            case 1:sb.append("C");
            break;
            case 2:sb.append("CC");
            break;
            case 3:sb.append("CCC");
            break;
            case 4:sb.append("CD");
            break;
            case 5:sb.append("D");
            break;
            case 6:sb.append("DC");
            break;
            case 7:sb.append("DCC");
            break;
            case 8:sb.append("DCCC");
            break;
            case 9:sb.append("CM");
            break;
        }
        num=num%100;
        switch(num/10){
            case 1:sb.append("X");
            break;
            case 2:sb.append("XX");
            break;
            case 3:sb.append("XXX");
            break;
            case 4:sb.append("XL");
            break;
            case 5:sb.append("L");
            break;
            case 6:sb.append("LX");
            break;
            case 7:sb.append("LXX");
            break;
            case 8:sb.append("LXXX");
            break;
            case 9:sb.append("XC");
            break;
        }
        num=num%10;
        switch(num){
            case 1:sb.append("I");
            break;
            case 2:sb.append("II");
            break;
            case 3:sb.append("III");
            break;
            case 4:sb.append("IV");
            break;
            case 5:sb.append("V");
            break;
            case 6:sb.append("VI");
            break;
            case 7:sb.append("VII");
            break;
            case 8:sb.append("VIII");
            break;
            case 9:sb.append("IX");
            break;
        }
        return sb.toString();
    }
}
