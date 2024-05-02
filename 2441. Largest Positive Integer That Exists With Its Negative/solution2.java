class Solution {
    public int findMaxK(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int x:nums){
            list.add(x);
        }
        int max=-1;
        for(int i=0;i<list.size();i++){
            int a=list.get(i);
            if(a>max){
                if(list.contains(-a)){
                    max=a;
                }
            }
        }
        return max;
    }
}
