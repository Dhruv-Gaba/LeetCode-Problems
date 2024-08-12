class KthLargest {
    List<Integer> stream;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        stream=new ArrayList<>();
        for(int num:nums){
            stream.add(num);
        }
        Collections.sort(stream);
    }
    
    public int add(int val) {
        int idx=getIndex(val);
        stream.add(idx,val);
        return stream.get(stream.size()-k);
    }

    private int getIndex(int val){
        int left=0;
        int right=stream.size()-1;
        while(left<=right){
            int mid=(left+right)/2;
            int midElement=stream.get(mid);
            if(midElement==val)return mid;
            else if(midElement>val)right=mid-1;
            else left=mid+1;
        }
        return left;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
