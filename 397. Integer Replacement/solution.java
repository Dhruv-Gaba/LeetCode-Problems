class Solution {
    public int integerReplacement(int n) {
        Map<Long,Integer> map=new HashMap<>();
        return helper(n,map);
    }
    public int helper(long x, Map<Long,Integer> map){
        if(x==1){
            return 0;
        }
        if(map.containsKey(x)){
            return map.get(x);
        }
        int result=0;
        if(x%2==0){
            result=1+helper(x/2,map);
        }
        else{
            result=1+Math.min(helper(x+1,map),helper(x-1,map));
        }
        map.put(x,result);
        return result;
    }
}
