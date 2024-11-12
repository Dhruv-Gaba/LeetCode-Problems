class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int ans[]=new int[queries.length];
        Arrays.sort(items, new Comparator<int[]>() {
            public int compare(final int[] entry1,final int[] entry2){
                if (entry1[0] == entry2[0])
                    return Integer.compare(entry1[1],entry2[1]);
                else
                    return Integer.compare(entry1[0],entry2[0]);
            }
        });
        int max=0;
        for(int i=0;i<items.length;i++){
            max=Math.max(max,items[i][1]);
            items[i][1]=max;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<items.length;i++){
            map.put(items[i][0],items[i][1]);
        }
        for(int i=0;i<queries.length;i++){
            int q=queries[i];
            if(q>=items[items.length-1][0]){
                ans[i]=items[items.length-1][1];
                continue;
            }
            while(q>0){
                if(map.containsKey(q)){
                    ans[i]=map.get(q);
                    break;
                }
                q--;
            }
        }
        return ans;
    }
}
