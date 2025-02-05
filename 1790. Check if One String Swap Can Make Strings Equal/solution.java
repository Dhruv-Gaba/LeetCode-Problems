class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int j=-1;
        int k=-1;
        int count=0;
        int n=s1.length();
        for(int i=0;i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
                if(j==-1){
                    j=i;
                }else{
                    k=i;
                }
            }
            if(count>2){
                return false;
            }
        }
        if(count==0){
            return true;
        }
        else if(count==2){
            return s1.charAt(j)==s2.charAt(k) && s1.charAt(k)==s2.charAt(j);
        }
        return false;
    }
}
