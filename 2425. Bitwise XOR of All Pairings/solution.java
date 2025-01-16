class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int ans=0;
        for(int x:nums1){
            ans=ans^(n2%2==0?0:x);
        }
        for(int x:nums2){
            ans=ans^(n1%2==0?0:x);
        }
        return ans;
    }
}
