class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[1]-b[1]));
        List<int[]> list=new ArrayList<>();
        list.add(intervals[0]);
        for(int interval[]:intervals){
            if(interval[0]<=list.get(list.size()-1)[1]){
                int start=interval[0];
                int end=interval[1];
                while(list.size()>0 && interval[0]<=list.get(list.size()-1)[1]){
                    start=Math.min(start,list.get(list.size()-1)[0]);
                    end=Math.max(end,list.get(list.size()-1)[1]);
                    list.remove(list.size()-1);
                }
                list.add(new int[]{start,end});
            }
            else{
                list.add(interval);
            }
        }
        int[][] ans=new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            ans[i][0]=list.get(i)[0];
            ans[i][1]=list.get(i)[1];
        }
        return ans;
    }
}
