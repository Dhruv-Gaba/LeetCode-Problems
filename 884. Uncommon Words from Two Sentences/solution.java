import java.util.StringTokenizer;
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String,Integer> map=new HashMap<>();
        StringTokenizer st1=new StringTokenizer(s1);
        StringTokenizer st2=new StringTokenizer(s2);
        while(st1.hasMoreTokens()){
            String word=st1.nextToken();
            map.put(word,map.getOrDefault(word,0)+1);
        }
        while(st2.hasMoreTokens()){
            String word=st2.nextToken();
            map.put(word,map.getOrDefault(word,0)+1);
        }
        List<String> list=new ArrayList<>();
        for(String key:map.keySet()){
            if(map.get(key)==1){
                list.add(key);
            }
        }
        String ans[]=new String[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}
