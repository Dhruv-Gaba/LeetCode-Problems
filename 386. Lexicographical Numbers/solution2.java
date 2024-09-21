class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String> list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(Integer.toString(i));
        }
        Collections.sort(list);
        List<Integer> ans=new ArrayList<>();
        for(String s:list){
            ans.add(Integer.parseInt(s));
        }
        return ans;
    }
}
