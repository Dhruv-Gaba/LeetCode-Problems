class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Set<Character> set=new HashSet<>();
        int n=p.length();
        char ch[]=p.toCharArray();
        for(char c:ch){
            set.add(c);
        }
        Arrays.sort(ch);
        String newP=new String(ch);
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<s.length()-n+1;i++){
            char c=s.charAt(i);
            if(set.contains(c)){
                // System.out.println(c);
                char[] ch1=s.substring(i,i+n).toCharArray();
                Arrays.sort(ch1);
                String newS=new String(ch1);
                // System.out.println(newS);
                // System.out.println(newP);
                if(newS.equals(newP)){
                    ans.add(i);
                }
            }
        }
        return ans;
    }
}
