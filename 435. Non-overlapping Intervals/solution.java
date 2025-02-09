class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Arrays.sort(intervals,Comparator.comparingDouble(o->o[1]));
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int count=0;
        int lastEnd=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<lastEnd){
                count++;
            }else{
                lastEnd=intervals[i][1];
            }
        }
        return count;
    }
}
