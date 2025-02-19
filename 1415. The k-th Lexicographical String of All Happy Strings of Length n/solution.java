class Solution {
    public String getHappyString(int n, int k) {
        List<String> result=new  ArrayList<>();
        happyStrings(result,n,k,new StringBuilder());
        return result.size()>=k?result.get(k-1):"";
    }
    public void happyStrings(List<String> result,int n,int k,StringBuilder sb){
        if(sb.length()==n){
            result.add(sb.toString());
            return;
        }
        for(int i=0;i<3;i++){
            if(sb.length()>0 && sb.charAt(sb.length()-1)==(char)('a'+i)){
                continue;
            }
            sb.append((char)('a'+i));
            happyStrings(result,n,k,sb);
            if(result.size()>=k){
                return;
            }
            sb.delete(sb.length()-1,sb.length());
        }

    }
}
