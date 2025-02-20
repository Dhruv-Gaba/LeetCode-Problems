class Solution {
    public String findDifferentBinaryString(String[] nums) {
        //USING FUNCTIONS
        int start=(int)Math.pow(2,nums.length-1);
        int end=(int)Math.pow(2,nums.length);
        Set<String> set=new HashSet<>(Arrays.asList(nums));
        for(int i=start;i<end;i++){
            String num=Integer.toBinaryString(i);
            if(!set.contains(num)){
                return num;
            }
        }
        return "0".repeat(nums.length);
    }
}
