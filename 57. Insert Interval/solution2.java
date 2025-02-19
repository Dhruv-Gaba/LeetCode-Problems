class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list=new ArrayList<>();
        for(int interval[]:intervals){
            list.add(new int[]{interval[0],interval[1]});
        }
        list.add(newInterval);
        Collections.sort(list,(a,b)->(a[1]-b[1]));
        List<int[]> result=new ArrayList<>();
        result.add(list.get(0));
        for(int interval[]:list){
            if(result.get(result.size()-1)[1]>=interval[0]){
                int start=interval[0];
                int end=interval[1];
                while(result.size()>0 && result.get(result.size()-1)[1]>=interval[0]){
                    start=Math.min(start,result.get(result.size()-1)[0]);
                    end=Math.max(end,result.get(result.size()-1)[1]);
                    result.remove(result.size()-1);
                }
                result.add(new int[]{start,end});
            }else{
                result.add(interval);
            }
        }
        int ans[][]=new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            ans[i][0]=result.get(i)[0];
            ans[i][1]=result.get(i)[1];
        }
        return ans;
    }
}
