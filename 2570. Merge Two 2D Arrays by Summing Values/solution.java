class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> list=new ArrayList<>();
        int i=0,j=0,k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i][0]==nums2[j][0]){
                int sum=nums1[i][1]+nums2[j][1];
                list.add(new int[]{nums1[i][0],sum});
                i++;
                j++;
            }
            else if(nums1[i][0]<nums2[j][0]){
                list.add(new int[]{nums1[i][0],nums1[i][1]});
                i++;
            }
            else{
                list.add(new int[]{nums2[j][0],nums2[j][1]});
                j++;
            }
        }
        while(i<nums1.length){
            list.add(new int[]{nums1[i][0],nums1[i][1]});
            i++;
        }
        while(j<nums2.length){
            list.add(new int[]{nums2[j][0],nums2[j][1]});
            j++;
        }
        int[][] ans=new int[list.size()][2];
        return list.toArray(ans);
    }
}
