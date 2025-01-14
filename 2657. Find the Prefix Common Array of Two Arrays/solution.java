class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        List<Integer> list=new ArrayList<>();
        int n=A.length;
        int ans[]=new int[n];
        if(A[0]==B[0]){
            ans[0]=1;
            list.add(A[0]);
        }
        else{
            ans[0]=0;
            list.add(A[0]);
            list.add(B[0]);
        }
        for(int i=1;i<n;i++){
            ans[i]=ans[i-1];
            if(list.contains(A[i])){
                ans[i]++;
            }
            else{
                list.add(A[i]);
            }
            if(list.contains(B[i])){
                ans[i]++;
            }else{
                list.add(B[i]);
            }
        }
        return ans;
    }
}
