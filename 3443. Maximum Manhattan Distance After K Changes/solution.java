class Solution {
    public int maxDistance(String s, int k) {
        int north=0,south=0,east=0,west=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='N'){
                north++;
            }
            else if(s.charAt(i)=='S'){
                south++;
            }
            else if(s.charAt(i)=='E'){
                east++;
            }else{
                west++;
            }
            int nn=north,ns=south,nw=west,ne=east,nk=k;
            if(nk>0 && north>=south){
                int diff=Math.min(south,nk);
                nn+=diff;
                nk-=diff;
                ns-=diff;
            }
            else if(nk>0 && south>north){
                int diff=Math.min(north,nk);
                ns+=diff;
                nk-=diff;
                nn-=diff;
            }
            if(nk>0 && east>=west){
                int diff=Math.min(west,nk);
                ne+=diff;
                nk-=diff;
                nw-=diff;
            }
            else if(nk>0 && west>east){
                int diff=Math.min(east,nk);
                nw+=diff;
                nk-=diff;
                ne-=diff;
            }
            max=Math.max(max,Math.abs(nn-ns)+Math.abs(ne-nw));
        }
        return max;
    }
}
