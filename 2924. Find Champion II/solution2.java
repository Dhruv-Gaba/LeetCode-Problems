class Solution {
    public int findChampion(int n, int[][] edges) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(i);
        }
        for(int x[]:edges){
            if(set.contains(x[1])){
                set.remove(x[1]);
            }
        }
        if(set.size()==1){
            for(int v:set){
                return v;
            }
        }
        return -1;
    }
}
