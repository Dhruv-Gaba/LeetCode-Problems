class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count=0;
        Arrays.sort(g);
        Arrays.sort(s);
        int idx=0;
        for(int i=0;i<g.length;i++){
            for(int j=idx;j<s.length;j++){
                if(s[j]>=g[i]){
                    count++;
                    idx=j+1;
                    g[i]=-1;
                    break;
                }
            }
            if(g[i]!=-1){
                return count;
            }
        }
        return count;
    }
}
