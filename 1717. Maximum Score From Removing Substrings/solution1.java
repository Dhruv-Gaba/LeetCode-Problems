class Solution {
    public int maximumGain(String s, int x, int y) {
        int acount=0;
        int bcount=0;
        int lesser=Math.min(x,y);
        int result=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch>'b'){
                result+=Math.min(acount,bcount)*lesser;
                acount=0;
                bcount=0;
            }
            else if(ch=='a'){
                if(y>=x && bcount>0){
                    bcount--;
                    result+=y;
                }
                else{
                    acount++;
                }
            }
            else{
                if(x>y && acount>0){
                    acount--;
                    result+=x;
                }
                else{
                    bcount++;
                }
            }
        }
        result+=Math.min(acount,bcount)*lesser;
        return result;
    }
}
