class TrieNode{
    TrieNode next[]=new TrieNode[26];
    int count=0;
}

class Solution {
    TrieNode root=new TrieNode();
    public int[] sumPrefixScores(String[] words) {
        for(String s:words){
            insert(s);
        }
        int ans[]=new int[words.length];
        for(int i=0;i<words.length;i++){
            ans[i]=count(words[i]);
        }
        return ans;
    }
    private void insert(String s){
        TrieNode node=root;
        for(char c:s.toCharArray()){
            if(node.next[c-'a']==null){
                node.next[c-'a']=new TrieNode();
            }
            node.next[c-'a'].count++;
            node=node.next[c-'a'];
        }
    }
    private int count(String s){
        TrieNode node=root;
        int ans=0;
        for(char c:s.toCharArray()){
            ans+=node.next[c-'a'].count;
            node=node.next[c-'a'];
        }
        return ans;
    }
}
