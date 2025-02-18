class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder sb=new StringBuilder();
        boolean used[]=new boolean[10];
        constructString(pattern,sb,-1,used);
        return sb.toString();
    }
    public boolean constructString(String pattern,StringBuilder sb,int pos,boolean[] used){
        if(pos==pattern.length()){
            return true;
        }
        for(int i=1;i<10;i++){
            if(used[i])continue;
            if(pos==-1){
                used[i]=true;
                sb.append(Integer.toString(i));
                if(constructString(pattern,sb,pos+1,used)){
                    return true;
                }
                sb.delete(sb.length()-1,sb.length());
                used[i]=false;
            }else{
                if(pattern.charAt(pos)=='I' && (sb.charAt(pos)-'0')>=i){
                    continue;
                }
                if(pattern.charAt(pos)=='D' && (sb.charAt(pos)-'0')<=i){
                    break;
                }
                used[i]=true;
                sb.append(Integer.toString(i));
                if(constructString(pattern,sb,pos+1,used)){
                    return true;
                }
                sb.delete(sb.length()-1,sb.length());
                used[i]=false;
            }

        }
        return false;
    }
}
