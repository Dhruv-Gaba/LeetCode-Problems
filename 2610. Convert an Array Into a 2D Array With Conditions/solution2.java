class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        int[] count=new int[nums.length+1];
        for(int i:nums){
            if(count[i]==list.size()){
                list.add(new ArrayList<>());
            }
            list.get(count[i]).add(i);
            count[i]++;
        }
        return list;
    }
}
