class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        int[] count=new int[26];
        int n=s.length();
        int k=p.length();
        if(s.length()<p.length()){
            return ans;
        }
        for(int i=0;i<k;i++){
            count[p.charAt(i)-'a']++;
            count[s.charAt(i)-'a']--;
        }
        int diff=0;
        for(int x:count){
            if(x>0){
                diff++;
            }
        }
        if(diff==0){
            ans.add(0);
        }
        for(int i=k;i<n;i++){
            count[s.charAt(i-k)-'a']++;
            if(count[s.charAt(i-k)-'a']==1){
                diff++;
            }
            count[s.charAt(i)-'a']--;
            if(count[s.charAt(i)-'a']==0){
                diff--;
            }
            if(diff==0){
                ans.add(i-k+1);
            }
        }
        return ans;
    }
}
