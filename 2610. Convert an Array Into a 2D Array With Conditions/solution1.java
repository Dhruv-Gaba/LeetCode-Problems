class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        int count=0;
        while(count<nums.length){
            ArrayList<Integer> ans=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=0 && !ans.contains(nums[i])){
                    ans.add(nums[i]);
                    nums[i]=0;
                    count++;
                }
            }
            list.add(ans);
        }
        return list;
    }
}
