class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int p=0,g=0,m=0;
        int ans=0,count=0;
        for(int i=0;i<garbage.length;i++){
            ans+=garbage[i].length();
            if(garbage[i].contains("P")){
                p=i;
            }
            if(garbage[i].contains("M")){
                m=i;
            }
            if(garbage[i].contains("G")){
                g=i;
            }
        }
        int max=Math.max(Math.max(p,m),g);
        for(int i=0;i<max;i++){
            if(i<p){
                ans+=travel[i];
            }
            if(i<m){
                ans+=travel[i];
            }
            if(i<g){
                ans+=travel[i];
            }
        }
        return ans;
    }
}
