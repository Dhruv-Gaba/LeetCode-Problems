//https://www.youtube.com/watch?v=TBCOBD-24oE
class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                map.put(nums[i]*nums[j],map.getOrDefault(nums[i]*nums[j],0)+1);
            }
        }
        int count=0;
        for(int key:map.keySet()){
            if(map.get(key)>1){
                int numOfPairs=map.get(key);
                int numOfWays=numOfPairs*(numOfPairs-1)/2;   //nC2
                count+=(numOfWays*8);
            }
        }
        return count;
    }
}
