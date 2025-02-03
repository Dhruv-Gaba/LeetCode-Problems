class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
        // Your code here
        int n=arr.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(arr[b]-arr[a]));
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            pq.add(i);
        }
        ans.add(arr[pq.peek()]);
        for(int i=k;i<n;i++){
            pq.add(i);
            while(pq.peek()<=i-k){
                pq.poll();
            }
            ans.add(arr[pq.peek()]);
        }
        return ans;
    }
}
