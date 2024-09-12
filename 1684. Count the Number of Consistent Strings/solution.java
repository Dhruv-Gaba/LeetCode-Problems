class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count[]=new int[26];
        for(char x:allowed.toCharArray()){
            count[x-'a']++;
        }
        int non=0;
        for(String word:words){
            for(char x:word.toCharArray()){
                if(count[x-'a']==0){
                    non++;
                    break;
                }
            }
        }
        return words.length-non;
    }
}
