class Solution {
    public int numberOfSubstrings(String s) {
        int i=0;
        int j=0;
        int a=0,b=0,c=0;
        int n=s.length();
        int count=0;
        while(j<s.length()){
            if(a<1 || b<1 || c<1){
                while(j<s.length() && (a<1 || b<1 || c<1)){
                    if(s.charAt(j)=='a'){
                        a++;
                    }else if(s.charAt(j)=='b'){
                        b++;
                    }else{
                        c++;
                    }
                    j++;
                }
            }
            while(a>0 && b>0 && c>0){
                count+=(n-j+1);
                if(s.charAt(i)=='a'){
                    a--;
                }else if(s.charAt(i)=='b'){
                    b--;
                }else{
                    c--;
                }
                i++;
            }
        }
        return count;
    }
}
