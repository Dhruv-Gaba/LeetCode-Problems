class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        long cumulativeSum=0;
        int min=Integer.MAX_VALUE;
        PriorityQueue<Pair<Long,Integer>> prefixSumHeap=new PriorityQueue<>((a,b)->Long.compare(a.getKey(),b.getKey()));
        for(int i=0;i<n;i++){
            cumulativeSum+=nums[i];
            if(cumulativeSum>=k){
                min=Math.min(min,i+1);
            }
            while(!prefixSumHeap.isEmpty() && cumulativeSum-prefixSumHeap.peek().getKey()>=k){
                min=Math.min(min,i-prefixSumHeap.poll().getValue());
            }
            prefixSumHeap.offer(new Pair<>(cumulativeSum,i));
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}
