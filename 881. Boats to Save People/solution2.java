class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count=0,i=0,j=people.length-1;
        while(i<=j){
            if(people[i]+people[j]<=limit){
                i++;
                j--;
                count++;
            }
            else{
                j--;
                count++;
            }
        }
        return count;
    }
}
