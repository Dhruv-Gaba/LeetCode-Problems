class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetTime[]=times[targetFriend];
        Arrays.sort(times,(a,b)->Integer.compare(a[0],b[0]));
        int chairTime[]=new int[times.length];
        for(int[] time:times){
            for(int i=0;i<chairTime.length;i++){
                if(chairTime[i]<=time[0]){
                    chairTime[i]=time[1];
                    if(Arrays.equals(time,targetTime)){
                        return i;
                    }
                    break;
                }
            }
        }
        return 0;
    }
}
