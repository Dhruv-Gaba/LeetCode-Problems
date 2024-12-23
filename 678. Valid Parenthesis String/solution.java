class Solution {
    public boolean checkValidString(String s) {
        int open=0;
        int star=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                open++;
            }
            else if(ch=='*'){
                star++;
            }
            else if(ch==')'){
                if(open>0){
                    open--;
                }
                else if(star>0){
                    star--;
                }
                else{
                    return false;
                }
            }
        }
        open=0;
        star=0;
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch==')'){
                open++;
            }
            else if(ch=='*'){
                star++;
            }
            else if(ch=='('){
                if(open>0){
                    open--;
                }
                else if(star>0){
                    star--;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
