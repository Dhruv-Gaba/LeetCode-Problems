class Solution {
    public String findDifferentBinaryString(String[] nums) {
        //BACKTRACKING
        Set<String> set=new HashSet<>(Arrays.asList(nums));
        StringBuilder sb=new StringBuilder();
        binaryStrings(set,sb,nums.length);
        return sb.toString();
    }
    boolean binaryStrings(Set<String> set,StringBuilder sb,int n){
        if(sb.length()==n){
            if(!set.contains(sb.toString()))return true;
            else return false;
        }
        for(int i=0;i<2;i++){
            sb.append(i);
            if(binaryStrings(set,sb,n)){
                return true;
            }
            sb.delete(sb.length()-1,sb.length());
        }
        return false;
    }
}
