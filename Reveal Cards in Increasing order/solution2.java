class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int ans[]=new int[deck.length];
        int i=0,j=0;
        boolean skip=false;
        while(i<deck.length){
            j=0;
            while(j<ans.length){
                if(ans[j]==0){
                    if(!skip){
                        ans[j]=deck[i];
                        i++;
                    }
                    skip=!skip;
                }
                j++;
            }
        }
        return ans;
    }
}
