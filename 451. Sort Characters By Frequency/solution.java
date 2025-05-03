class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        StringBuilder sb=new StringBuilder();
        map.keySet().stream().sorted((a,b)->{
            return map.get(b)-map.get(a);
        }).forEach(c->{
            int freq=map.get(c);
            for(int i=0;i<freq;i++){
                sb.append(c);
            }
        });
        return sb.toString();
    }
}
