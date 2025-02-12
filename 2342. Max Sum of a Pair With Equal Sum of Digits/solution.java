class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=-1;
        for(int i=0;i<nums.length;i++){
            int sum=sumOfDigits(nums[i]);
            if(map.containsKey(sum)){
                max=Math.max(max,nums[i]+map.get(sum));
            }
            map.put(sum,Math.max(map.getOrDefault(sum,-1),nums[i]));
        }
        return max;
    }
    public int sumOfDigits(int n){
        int sum=0;
        while(n>0){
            int rem=n%10;
            n=n/10;
            sum+=rem;
        }
        return sum;
    }
}
