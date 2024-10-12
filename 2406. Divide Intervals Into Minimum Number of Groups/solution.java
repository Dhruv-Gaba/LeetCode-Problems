class Solution {
    public int minGroups(int[][] intervals) {
        List<Integer> start=new ArrayList<>();
        List<Integer> end=new ArrayList<>();
        for(int[] interval:intervals){
            start.add(interval[0]);
            end.add(interval[1]);
        }
        Collections.sort(start);
        Collections.sort(end);
        int j=0;
        int count=0;
        int maxCount=0;
        for(int i=0;i<start.size();i++){
            count++;
            while(j<end.size() && end.get(j)<start.get(i)){
                count--;
                j++;
            }
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }
}
