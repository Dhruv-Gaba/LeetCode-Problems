class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                if(a[0]!=b[0]){
                    return a[0]-b[0];
                }else{
                    return a[1]-b[1];
                }
            }
        });
        int limit=0;
        for(int event[]:events){
            limit=Math.max(limit,event[1]);
        }
        PriorityQueue<Integer> options=new PriorityQueue<>();
        int d=1;
        int i=0;
        int count=0;
        while(d<=limit){
            while(i<events.length && events[i][0]==d){
                options.add(events[i][1]);
                i++;
            }
            while(!options.isEmpty() && options.peek()<d){
                options.poll();
            }
            if(!options.isEmpty()){
                options.poll();
                count++;
            }
            d++;
        }
        return count;
    }
}

