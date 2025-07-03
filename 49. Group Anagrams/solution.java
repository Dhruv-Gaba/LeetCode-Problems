class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] ch=str.toCharArray();
            Arrays.sort(ch);
            String newStr=new String(ch);
            map.computeIfAbsent(newStr,k->new ArrayList<>()).add(str);
        }
        List<List<String>> ans=new ArrayList<>();
        for(List<String> list: map.values()){
            ans.add(list);
        }
        return ans;
    }
}
