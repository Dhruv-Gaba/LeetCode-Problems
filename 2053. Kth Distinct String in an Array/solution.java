class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String x:arr){
            map.merge(x,1,Integer::sum);
        }
        for(String x:arr){
            if(map.get(x)==1){
                k--;
            }
            if(k==0){
                return x;
            }
        }
        return "";
    }
}
