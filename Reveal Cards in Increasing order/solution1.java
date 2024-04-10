class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int ans[]=new int[deck.length];
        return reveal(deck,ans,0,0,false);
    }
    public static int[] reveal(int[] deck, int ans[], int ansIdx, int deckIdx, boolean skip){
        int n=deck.length;
        if(deckIdx==n){
            return ans;
        }
        while(ansIdx<n){
            if(ans[ansIdx]==0){
                if(!skip){
                    ans[ansIdx]=deck[deckIdx];
                    deckIdx++;
                }
                skip=!skip;
            }
            ansIdx++;
        }
        return reveal(deck,ans,0,deckIdx,skip);
    }
}
