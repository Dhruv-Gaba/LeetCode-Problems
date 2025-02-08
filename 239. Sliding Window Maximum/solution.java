//can be solved using deque for better tc

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->nums[b]-nums[a]);
        for(int i=0;i<k;i++){
            pq.add(i);
        }
        int n=nums.length;
        int ans[]=new int[n-k+1];
        ans[0]=nums[pq.peek()];
        for(int i=k;i<n;i++){
            pq.add(i);
            while(pq.peek()<=i-k){
                pq.poll();
            }
            ans[i-k+1]=nums[pq.peek()];
        }
        return ans;
    }
}
