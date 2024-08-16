class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int l=Integer.MAX_VALUE;
        int minIdx=-1;
        int h=Integer.MIN_VALUE;
        int maxIdx=-1;
        int l2=Integer.MAX_VALUE;
        int h2=Integer.MIN_VALUE;

        for(int i=0;i<arrays.size();i++){
            List<Integer> list=arrays.get(i);
            int currMin=list.get(0);
            int currMax=list.get(list.size()-1);
            if(l>currMin){
                minIdx=i;
                l2=l;
                l=currMin;
            }
            else if(l2>currMin){
                l2=currMin;
            }
            if(h<currMax){
                maxIdx=i;
                h2=h;
                h=currMax;
            }
            else if(h2<currMax){
                h2=currMax;
            }
            
        }
        return minIdx==maxIdx?Math.max(h-l2,h2-l):h-l;
    }
}
