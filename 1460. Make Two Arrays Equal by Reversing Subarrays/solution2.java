class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int max=Integer.MIN_VALUE;
        for(int x:arr){
            max=Math.max(max,x);
        }
        int count1[]=new int[max+1];
        int count2[]=new int[max+1];
        for(int i=0;i<target.length;i++){
            count1[arr[i]]++;
            if(target[i]>max){
                return false;
            }
            count2[target[i]]++;
        }
        for(int i=0;i<count1.length;i++){
            if(count1[i]!=count2[i]){
                return false;
            }
        }
        return true;
    }
}
