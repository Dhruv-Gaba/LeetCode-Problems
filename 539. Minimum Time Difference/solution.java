class Solution {
    public int findMinDifference(List<String> timePoints) {
        int minutes[]=new int[timePoints.size()];
        for(int i=0;i<timePoints.size();i++){
            String time=timePoints.get(i);
            minutes[i]=Integer.parseInt(time.substring(0,2))*60+Integer.parseInt(time.substring(3,5));
        }
        Arrays.sort(minutes);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<minutes.length-1;i++){
            min=Math.min(min,minutes[i+1]-minutes[i]);
        }
        min=Math.min(min,1440-minutes[minutes.length-1]+minutes[0]);
        return min;
    }
}
