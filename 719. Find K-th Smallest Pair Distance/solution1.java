class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low=0;
        int high=nums[nums.length-1]-nums[0];
        while(low<high){
            // int mid=(low+high)/2;
            int mid = low +(high-low)/2;
            int count=countPairsWithMaxDistance(nums,mid);
            if(count<k){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }

    private int countPairsWithMaxDistance(int[] nums,int max){
        int count=0;
        int left=0;
        for(int right=1;right<nums.length;right++){
            while(nums[right]-nums[left]>max){
                left++;
            }
            count+=right-left;
        }
        return count;
    }
}
