class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(long x:nums){
            pq.add(x);
        }
        int count=0;
        while(!pq.isEmpty() && pq.peek()<k){
            long first=pq.poll();
            if(pq.isEmpty()){
                break;
            }
            long second=pq.poll();
            long newNum=Math.min(first,second)*2+Math.max(first,second);
            pq.add(newNum);
            count++;
        }
        return count;
    }
}
