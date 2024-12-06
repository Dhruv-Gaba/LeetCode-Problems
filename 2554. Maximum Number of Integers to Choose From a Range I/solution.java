class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set=new HashSet<>();
        for(int x:banned){
            set.add(x);
        }
        int sum=0;
        int count=0;
        for(int i=1;i<=n;i++){
            if(set.contains(i)){
                continue;
            }
            sum+=i;
            if(sum<=maxSum){
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }
}
