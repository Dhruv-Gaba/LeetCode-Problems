class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int count[]=new int[1001];
        for(int i=0;i<target.length;i++){
            count[arr[i]]++;
            count[target[i]]--;
        }
        for(int i=0;i<arr.length;i++){
            if(count[arr[i]]!=0 || count[target[i]]!=0){
                return false;
            }
        }
        return true;
    }
}
