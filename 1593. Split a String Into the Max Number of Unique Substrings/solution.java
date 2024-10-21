class Solution {
    public int maxUniqueSplit(String s) {
        HashSet<String> set=new HashSet<>();
        return backtrack(s,0,set);
    }
    private static int backtrack(String s,int start,HashSet<String> set){
        if(start==s.length()){
            return 0;
        }
        int maxCount=0;
        for(int i=start+1;i<=s.length();i++){
            String substr=s.substring(start,i);
            if(!set.contains(substr)){
                set.add(substr);
                maxCount=Math.max(maxCount,1+backtrack(s,i,set));
                set.remove(substr);
            }
        }
        return maxCount;
    }
}
