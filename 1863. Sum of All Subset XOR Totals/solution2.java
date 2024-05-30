class Solution {
    public int subsetXORSum(int[] nums) {
        return subsetXOR(nums,0,0);
    }
    public static int subsetXOR(int[] nums,int i,int currentXOR){
        if(nums.length==i){
            return currentXOR;
        }
        int withElement=subsetXOR(nums,i+1,currentXOR^nums[i]);
        int withoutElement=subsetXOR(nums,i+1,currentXOR);
        return withElement+withoutElement;
    }
    }
}
