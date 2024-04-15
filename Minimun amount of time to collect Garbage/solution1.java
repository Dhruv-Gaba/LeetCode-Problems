class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int ans=0;
        for(int x:travel){
            ans+=x;
        }
        ans*=3;
        for(int i=0;i<garbage.length;i++){
            ans+=garbage[i].length();
        }
        ans-=check(garbage,travel,"P");
        ans-=check(garbage,travel,"M");
        ans-=check(garbage,travel,"G");
        return ans;
    }
    public static int check(String[] garbage, int[] travel, String g){
        int less=0;
        for(int i=garbage.length-1;i>0;i--){
            if(garbage[i].contains(g)){
                break;
            }
            else{
                less+=travel[i-1];
            }
        }
        return less;
    }
}
