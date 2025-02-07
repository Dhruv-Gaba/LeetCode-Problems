class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer,Integer> colorMap=new HashMap<>();
        Map<Integer,Integer> colorCount=new HashMap<>();
        int ans[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int[] query=queries[i];
            if(colorMap.containsKey(query[0])){
                int oldColor=colorMap.get(query[0]);
                if(colorCount.get(oldColor)==1){
                    colorCount.remove(oldColor);
                }
                else{
                    colorCount.put(oldColor,colorCount.get(oldColor)-1);
                }
            }
            colorMap.put(query[0],query[1]);
            colorCount.put(query[1],colorCount.getOrDefault(query[1],0)+1);
            ans[i]=colorCount.keySet().size();
        }
        return ans;
    }
}
