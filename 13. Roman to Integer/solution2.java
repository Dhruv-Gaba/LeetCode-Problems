class Solution {
    public int romanToInt(String s) {
        int val[]=new int[s.length()];
        int i=0,ans=0;
        for(char x:s.toCharArray()){
            switch(x){
                case 'I': val[i]=1;
                i++;
                break;
                case 'V': val[i]=5;
                i++;
                break;
                case 'X': val[i]=10;
                i++;
                break;
                case 'L': val[i]=50;
                i++;
                break;
                case 'C': val[i]=100;
                i++;
                break;
                case 'D': val[i]=500;
                i++;
                break;
                case 'M': val[i]=1000;
                i++;
                break;
            }
        }
        for(int j=0;j<val.length;j++){
            if(j<val.length-1 && val[j]<val[j+1]){
                ans-=val[j];
            }
            else{
                ans+=val[j];
            }
        }
        return ans;
    }
}
