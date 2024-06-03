class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int weight[]=new int[limit+1];
        for(int w:people){
            weight[w]++;
        }
        int i=0,j=limit;
        int count=0;
        while(i<=j){
            while(i<=j && weight[i]<=0){
                i++;
            }
            while(i<=j && weight[j]<=0){
                j--;
            }
            if(weight[i]<=0 && weight[j]<=0){
                break;
            }
            if(i+j<=limit){
                weight[i]--;
                weight[j]--;
                count++;
            }
            else{
                weight[j]--;
                count++;
            }
        }
        return count;
    }
}
