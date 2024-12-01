class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set=new HashSet<>();
        int count=0;
        for(int x:arr){
            set.add(x);
            if(x==0){
                count++;
            }
        }
        for(int x:arr){
            if(x==0 && count>1){
                return true;
            }
            else if(x!=0 && set.contains(2*x)){
                return true;
            }
        }
        return false;
    }
}
