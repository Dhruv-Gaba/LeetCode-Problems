class Solution {
    public int[] minOperations(String boxes) {
        char box[]=boxes.toCharArray();
        int n=boxes.length();
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                if(box[j]=='1'){
                    ans[i]+=Math.abs(i-j);
                }
            }
        }
        return ans;
    }
}
