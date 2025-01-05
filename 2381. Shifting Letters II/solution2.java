class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        char arr[]=s.toCharArray();
        for(int shift[]:shifts){
            if(shift[2]==1){
                for(int i=shift[0];i<=shift[1];i++){
                    if(arr[i]=='z'){
                        arr[i]='a';
                    }
                    else{
                        arr[i]=((char)(arr[i]+1));
                    }
                }
            }
            else{
                for(int i=shift[0];i<=shift[1];i++){
                    if(arr[i]=='a'){
                        arr[i]='z';
                    }
                    else{
                        arr[i]=((char)(arr[i]-1));
                    }
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char x:arr){
            sb.append(x);
        }
        return sb.toString();
    }
}
