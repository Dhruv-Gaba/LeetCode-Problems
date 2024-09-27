class MyCalendarTwo {
    List<int[]> bookings;
    List<int[]> overlapBookings;

    private boolean doesOverlap(int start1,int end1,int start2,int end2){
        return Math.max(start1,start2)<Math.min(end1,end2);
    }

    private int[] getOverlapedInterval(int start1,int end1,int start2,int end2){
        return new int[]{Math.max(start1,start2),Math.min(end1,end2)};
    }

    public MyCalendarTwo() {
        bookings=new ArrayList<>();
        overlapBookings=new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] booking:overlapBookings){
            if(doesOverlap(start,end,booking[0],booking[1])){
                return false;
            }
        }
        for(int[] booking:bookings){
            if(doesOverlap(start,end,booking[0],booking[1])){
                overlapBookings.add(getOverlapedInterval(start,end,booking[0],booking[1]));
            }
        }
        bookings.add(new int[]{start,end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
