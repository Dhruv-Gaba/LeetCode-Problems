class MyCalendar {
    List<int[]> calendar;
    public MyCalendar() {
        calendar=new ArrayList<>();
    }
    public boolean book(int start, int end) {
        for(int[] arr:calendar){
            if(arr[0]<end && start<arr[1]){
                return false;
            }
        }
        calendar.add(new int[]{start,end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
